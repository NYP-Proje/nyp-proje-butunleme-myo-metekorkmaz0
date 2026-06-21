# Kurumsal CRM ve Teknik Destek (Help Desk) Sistemi

## Proje Hakkında
Bu proje, Beykoz Üniversitesi Bilgisayar Programcılığı bölümü Nesne Yönelimli Programlama dersi bütünleme ödevi kapsamında geliştirilmiş, kurumsal firmalar için müşteri yönetimi ve teknik destek (ticket) süreçlerini dijitalleştiren web tabanlı bir otomasyon sistemidir. Sistem, kurumsal standartlara ve Katmanlı Mimari (Layered Architecture) prensiplerine tam uyumlu olarak tasarlanmıştır.

##  Kullanılan Teknolojiler
* **Backend:** Java, Spring Boot, Spring Data JPA (Hibernate)
* **Frontend:** Thymeleaf Şablon Motoru, HTML5, Bootstrap 5
* **Veritabanı:** Microsoft SQL Server
* **Araçlar:** Maven, IntelliJ IDEA, GitHub Desktop

##  Temel Modüller ve Özellikler
* **Müşteri Yönetimi (CRUD):** Sisteme yeni firma/müşteri ekleme, listeleme, bilgi güncelleme ve pasife alma/silme işlemleri.
* **Müşteri Destek Paneli:** Her müşterinin sadece kendi teknik destek taleplerini (ticket) görebildiği, yeni arıza bildirimleri oluşturabildiği ve sürecin "Beklemede/İşlemde/Çözüldü" aşamalarını takip edebildiği izole arayüz.
* **Admin (Teknik Ekip) Paneli:** Sistem yöneticisinin tüm firmalardan gelen destek taleplerini öncelik sırasına göre tek bir merkezden yönetebildiği operasyon ekranı.

## Kurulum ve Çalıştırma Talimatları
1. Repository'yi yerel bilgisayarınıza klonlayın.
2. Microsoft SQL Server üzerinde `CorporateCRM` adında boş bir veritabanı oluşturun.
3. `src/main/resources/application.properties` dosyasındaki veritabanı kullanıcı adı (`sa`) ve şifresini yerel sunucunuza göre ayarlayın.
4. Projeyi çalıştırdığınızda tablolar (`customers`, `tickets`) Hibernate tarafından otomatik olarak generate edilecektir.
5. Tarayıcınız üzerinden aşağıdaki rotaları kullanarak sistemi test edebilirsiniz:
    - Ana Müşteri Yönetimi: `http://localhost:8080/customers`
    - Admin Bilet (Ticket) Paneli: `http://localhost:8080/tickets/admin`
    - Müşteri Özel Paneli (Örn. ID=1): `http://localhost:8080/tickets/customer/1`

---
**Geliştirici:** Mete Korkmaz