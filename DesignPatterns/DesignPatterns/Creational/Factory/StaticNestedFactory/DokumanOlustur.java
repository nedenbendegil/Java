class Dokuman {
  private String dosyaIsmi;
  private String dosyaTuru;
  private String dosyaSahibi;
  

  private Dokuman(String dosyaIsmi, String dosyaTuru, String dosyaSahibi) {
    this.dosyaIsmi = dosyaIsmi;
    this.dosyaTuru = dosyaTuru;
    this.dosyaSahibi = dosyaSahibi;
  }

  public void hakkinda() {
    System.out.println("Dokuman ismi: " + dosyaIsmi);
    System.out.println("Dokuman turu: " + dosyaTuru);
    System.out.println("Dokuman sahibi: " + dosyaSahibi);
  }

  public void goruntule() {
    switch(dosyaTuru) {
      case "PDF":
        System.out.println("PDF dosyasi goruntuleniyor");
        break;
      case "Word":
        System.out.println("Word dosyasi goruntuleniyor");
        break;
      case "Excel":
        System.out.println("Excel dosyasi goruntuleniyor");
        break;
      default:
        System.out.println("Bu ne dosyasi aq!");
        break;
    }
  }

  public static class DokumanFabrika {
    public static Dokuman createPDF(String isim, String owner) {
      return new Dokuman(isim, "PDF", owner);
    }
    public static Dokuman createWord(String isim, String owner) {
      return new Dokuman(isim, "Word", owner);
    }
    public static Dokuman createExcel(String isim, String owner) {
      return new Dokuman(isim, "Excel", owner);
    }
  }
}



public class DokumanOlustur {
  public static void main(String[] args) {
    Dokuman kitap = Dokuman.DokumanFabrika.createPDF("Dally ve arkadaslari", "Admin");
    Dokuman word = Dokuman.DokumanFabrika.createWord("Essayim", "Ogrenci14");

    kitap.hakkinda();
    kitap.goruntule();
    word.goruntule();
  }
}
