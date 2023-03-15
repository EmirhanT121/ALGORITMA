import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] dizi = new int[10000];
        Random random = new Random();
        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = random.nextInt(10000);
        }

        long baslangic1 = System.currentTimeMillis();
        quickSort(dizi, 0, dizi.length - 1);
        long bitis1 = System.currentTimeMillis();
        long sure1 = (bitis1 - baslangic1);

        long baslangic2 = System.currentTimeMillis();
        Brute(dizi);
        long bitis2 = System.currentTimeMillis();
        long sure2 = (bitis2 - baslangic2);

        System.out.println("Sıralı dizi: ");
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + " ");
        }

        System.out.println("\n\nQuick Sort çalışma süresi: " + sure1 + " milisaniye");
        System.out.println("Brute Force çalışma süresi: " + sure2 + " milisaniye");

        if (sure1 > sure2){
            System.out.println("\nBrute Force, işlemi Quick Sort'a göre daha hızlı sonuçlandırmıştır.");
        }else if (sure1 < sure2){
            System.out.println("\nQuick Sort, işlemi Brute Force'a göre daha hızlı sonuçlandırmıştır.");
        }else {
            System.out.println("\nİşlemi, Quick Sort ve Brute Force aynı sürede sonuçlandırmıştır.");
        }
    }

    public static void quickSort (int[] dizi, int ilk, int son) {
        if (ilk < son) {
            int pivotIndex = ikiye_ayirma(dizi, ilk, son);
            quickSort(dizi, ilk, pivotIndex - 1);
            quickSort(dizi, pivotIndex + 1, son);
        }
    }

    public static int ikiye_ayirma (int[] dizi, int ilk, int son) {
        int pivot = dizi[son];
        int i = ilk - 1;
        for (int j = ilk; j <= son - 1; j++) {
            if (dizi[j] <= pivot) {
                i++;
                degistirme(dizi, i, j);
            }
        }
        degistirme(dizi, i + 1, son);
        return i + 1;
    }

    public static void degistirme (int[] dizi, int i, int j) {
        int flag = dizi[i];
        dizi[i] = dizi[j];
        dizi[j] = flag;
    }


    public static void Brute (int[] dizi) {
        for (int i = 0; i < dizi.length; i++) {
            for (int j = i + 1; j < dizi.length; j++) {
                if (dizi[i] > dizi[j]) {
                    degistirme(dizi, i, j);
                }
            }
        }
    }

}
