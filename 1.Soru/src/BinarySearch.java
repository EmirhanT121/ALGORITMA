import java.util.Random;

public class BinarySearch {

    public static void main(String[] args) {
        int[] dizi = new int[10000];
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            dizi[i] = rand.nextInt();
        }

        // Dizideki en büyük öğeyi BinarySearch ile bulmak için
        // dizinin sıralı olması gerekiyordu bu yüzden QuickSort ile sıraladım

        long baslangic1 = System.nanoTime();
        quickSort(dizi, 0, dizi.length - 1);
        int cevap1 = binarySearch(dizi);
        long bitis1 = System.nanoTime();
        long sure1 = bitis1 - baslangic1;

        // Brute Force ile en büyük öğeyi bulma ve çalışma süresini ölçme
        long baslangic2 = System.nanoTime();
        int cevap2 = Brute(dizi);
        long bitis2 = System.nanoTime();
        long sure2 = bitis2 - baslangic2;


        System.out.println("Binary Search ile en büyük sayı: " + cevap1);
        System.out.println("Binary Search çalışma süresi: " + sure1 + " nanosaniye");
        System.out.println("\nBrute Force ile en büyük sayı: " + cevap2);
        System.out.println("Brute Force çalışma süresi: " + sure2 + " nanosaniye");

        if (sure1 > sure2){
            System.out.println("\nBrute Force, işlemi Binary Search'e göre daha hızlı sonuçlandırmıştır.");
        }else if (sure1 < sure2){
            System.out.println("\nBinary Search, işlemi Brute Force'a göre daha hızlı sonuçlandırmıştır.");
        }else {
            System.out.println("\nİşlemi, Binary Search ve Brute Force aynı sürede sonuçlandırmıştır.");
        }
    }

    public static int binarySearch(int[] dizi) {
        int bas = 0;
        int son = dizi.length - 1;
        int max = dizi[son];
        while (bas <= son) {
            int orta = (bas + son) / 2;
            if (dizi[orta] > max) {
                max = dizi[orta];
            }
            if (dizi[orta] < dizi[son]) {
                son = orta - 1;
            } else {
                bas = orta + 1;
            }
        }
        return max;
    }

    public static int Brute(int[] dizi) {
        int max = 0;
        for (int i = 0; i < dizi.length; i++) {
            if (dizi[i] > max) {
                max = dizi[i];
            }
        }
        return max;
    }






    public static void quickSort(int[] dizi, int ilk, int son) {
        if (ilk < son) {
            int pivotIndex = ikiye_ayirma(dizi, ilk, son);
            quickSort(dizi, ilk, pivotIndex - 1);
            quickSort(dizi, pivotIndex + 1, son);
        }
    }

    public static int ikiye_ayirma(int[] dizi, int ilk, int son) {
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

    public static void degistirme(int[] dizi, int i, int j) {
        int flag = dizi[i];
        dizi[i] = dizi[j];
        dizi[j] = flag;
    }
}