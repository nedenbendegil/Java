class threadOlustur extends Thread {
  // extends dedigimizde, "Thread" sinifinin butun kendi fonksiyonlarini kullanabiliyoruz
  // bu sayede Thread sinifinin kendi icindeki paralel calistirma mantigina dokunmuyor
  // sadece istedigimiz beheaviouru kullaniyoruz

  public void run() {
    // run() fonksiyonu extend ettigimiz Thread sinifinda var,
    // biz bunu "istedigimiz davranisi" enjekte etmek icin override ediyoruz burada
    
     for (int i = 1; i <= 5; i++) {
        System.out.println("1inci Thread:" + i); // i yi yazdiriyorum, array de olabilirdi
        try {
          Thread.sleep(500); // 0.5 saniye bekletiyorum, gercekten islem yapiyormus gibi
        } catch (InterruptedException e) { /* hata bulsan da bisiy yapma ornek ztn*/ }
     }
  }
}


public class birinci {
  public static void main(String[] args) {
    threadOlustur birinciThread = new threadOlustur();
    birinciThread.start(); // biz bunu yazmadik ama extend ettigimiz classda var

    // burada kendi loopumuz olsun, yine belki erray okuyormusuz gibi hayal et
    for (int i = 1; i <= 5; i++) {
         System.out.println("Main Thread: " + i);
         try { Thread.sleep(300); } catch (InterruptedException e) { }
     }
  }
}

