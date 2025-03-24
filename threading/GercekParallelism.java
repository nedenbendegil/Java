import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GercekParallelism {
    public static void main(String[] args) throws InterruptedException {
        // kac CPU core var ona bak
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Toplamda  " + processors + " tane CPU cekirdegim var.");
        
        // Parallelism icin ExecutorService kullaniliyor
        ExecutorService executor = Executors.newFixedThreadPool(processors);
        
        // Burada agir bir islem yaptircagaimiz icin once 2d Array olusturuyorum
        final long[][] results = new long[processors][1];
        
        // Her bir CPU core'unu tek tek geziyorum
        for (int i = 0; i < processors; i++) {
            final int threadIndex = i;
            // executora gonderiyorum islemi
            executor.submit(() -> {
                System.out.println("Su numarali thread " + threadIndex + " basladi goreve");
                
                // Burada bile bile boyle zor bir islem yaptiriyorum
                // Cunku parallelism ayni anda cok yuksek islem gucu gerekince kullanilir
                // Tek bir cekirdek yerine butun CPU yu bu hesaplamayaa gonderiyorum
                long sum = 0;
                for (long j = 0; j < 1_000_000_000; j++) {
                    if (j % 100_000_000 == 0) {
                        System.out.println("Numarali: " + threadIndex + " thread  " + (j/10_000_000) + "% tamamlandi");
                    }
                    sum += j % 10;
                }
                
                results[threadIndex][0] = sum;
                System.out.println("Thread numarasi: " + threadIndex + " sonucu: " + sum);
                return sum;
            });
        }
        
        // Executor kapat
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        
        System.out.println("Islem tamamalandi");
    }
}
