Görsel Arayüzü bulunan bir Stok Kartı Uygulaması.
Bu modülün amacı işletmedeki stokların kimlik bilgilerini oluşturarak kayıt altına almak,güncellemek,listelemek ve gerektiği durumlarda silmektir.


1. Arayüzde kaydet butonu olmalı ve butona basıldığında componentlerdeki bilgiler veritabanına
kaydedilmelidir.
2. Arayüzde sil butonu olmalı ve butona basıldığında stok kodu componentinde bulunan bilgi
kullanılarak kart silinmelidir.
3. Componentlere girilen bilgiler ile stok kartı güncellemesi yapılabilmelidir.
4. Varolan bir stok kartını kopyalayabilmeliyiz. Kullanıcıdan yeni kod bilgisi istenmelidir ve kodu
   dışında kopyalanan kartın diğer bilgileri yeni karta aktarılmalıdır.
6. Kayıtlı olan stok kartlarını listeleyebilmeliyiz. JTable kullanılmalıdır.
7. Liste üzerinde dolaşırken stok kartına ait tüm bilgileri ilgili componentlerde görebilmeliyiz.
8. Kayıtlı stok kartları arasında stok koduna bağlı olarak arama ve bulunan ilgili stok kartına ait tüm
   bilgilerin ilgili componenetlere gösterilmesi sağlanmalıdr.

🛠️ Proje Özellikleri:
a. Kurumsal mimari gözetilerek yazılmaya özen gösterilmiştir MVC yapısı kullanılmıştır.
b.Programlama Dili: Java (Versiyon 17)
c.Arayüz Tasarım Framework: Swing
d.Veritabanı: MySQL (Versiyon 8)
e.IDE: Eclipse (Versiyon 2022-09)

MySql DB

Alan Adı
CREATE TABLE IF NOT EXISTS StokKartlari (
    id INT AUTO_INCREMENT PRIMARY KEY, 
    StokKodu VARCHAR(50) UNIQUE,
    StokAdi VARCHAR(100),
    StokTipi INT(2),
    Birimi VARCHAR(10),
    Barkodu VARCHAR(30),
    KDVTipi DOUBLE,
    Aciklama TEXT,
    OlusturmaZamani DATETIME
);

GUI Component

id-
StokKodu -textfield
StokAdi -textfield
StokTipi -combobox
Birimi -combobox
Barkodu -textfield
KDVTipi -combobox
Aciklama -TextArea
OlusturmaZamani -FormattedTextArea




