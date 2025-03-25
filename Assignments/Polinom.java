public class Polinom {
    // HOCANIN VERDIGI DIYAGRAMDAN COPY PASTE BUNLARI
    private double ust;
    private double[] katsayilar;
    private double hata;
    private double alt;

    // setter fonksiyonu, hata neden 0.0001 dersen
    // double kullandigimiz icin precision hatalari oluyor
    // mesela 3.4 = 3.400000000002 falan cikiyor
    // ve hoca diyor ki f(c) = 0 ise bulmusuzdur
    // o yuzden boyle kucuk bi deger koydum
    // oteki turlu cidden c sifira esit mi diye kontrol etsek hayir degil olabilirdi!!
    public Polinom(double[] katsayilar) {
        this.katsayilar = katsayilar;
        this.hata = 0.000001;
    }

    // bu polinomu hesapliyor direkt askim
    // normalde butun katsayilara bakarak iste a1 * x^2 ... fln diye hesapliyor
    // ama neden peki ustune gidince katsayilar.length -1 - i
    // cunku senin hoca katsayilari tersten vermis
    // f(x) = x²-4 bunlarin katsayisni boyle vermis 1, 0, -4
    // ama biz burada x^0 yani (-4) den basliyorum o yuzden en sona gitmem lazim
    public double f(double x) {
        double sonuc = 0;
        for (int i = 0; i < katsayilar.length; i++) {
            sonuc += katsayilar[i] * Math.pow(x, katsayilar.length - 1 - i);
        }
        return sonuc;
    }

    // setter yine
    public void araligiBelirle(double alt, double ust) {
        this.alt = alt;
        this.ust = ust;
    }

    // hocanin verdigi algo
    // once a ve b uc noktlaarda nbasliyor
    // c yi baslangicta random degere esitliyoz
    public double kokBul() {
        double c = 69.696969;

        // askim c = 0 dan buyuk oldugu surece aramaya devam et diyorum
        while (Math.abs(f(c)) >= hata) {
            c = (alt + ust) / 2; // c orta noktadan baslat diyo hoca


            if (f(alt) * f(c) < 0) { // sonra da diyor ki bak araligi ona gore ayarla
                ust = c;
            } else {
                alt = c;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        double[] katsayilar = {1, 0, -4}; // f(x) = x²-4
        Polinom p = new Polinom(katsayilar);
        p.araligiBelirle(0, 8);
        double kok = p.kokBul();
        System.out.println(kok);
    }
}