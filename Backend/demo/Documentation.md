# Proje Dökümantasyonu

Bu dökümantasyon, projenin bağımlılıklarının nasıl yükleneceği ve birim testlerin nasıl çalıştırılacağı gibi temel bilgileri içermektedir.

## Bağımlılıkların Yüklenmesi

Projenin çalışması için aşağıdaki bağımlılıkların yüklenmesi gerekmektedir:

- [Spring Boot](https://spring.io/projects/spring-boot):
- [Maven](https://maven.apache.org/index.html): 

Bağımlılıkları yüklemek için aşağıdaki adımları izleyebilirsiniz:

## Maven Kurulumu

1. Maven'i indirin ve bilgisayarınıza kurun.
   - [Maven indirme sayfası](https://maven.apache.org/download.cgi)
   - İndirme işlemi bittikten sonra, zip arşivini çıkarın ve bir klasöre yerleştirin.
   - PATH ortam değişkenine Maven'in bin dizinini ekleyin.

2. Maven'in doğru şekilde kurulduğunu doğrulayın.
   - Terminali açın ve aşağıdaki komutu çalıştırın:
     ```
     mvn --version
     ```
   - Sistem çıktısında Maven sürümü ve diğer bilgiler görüntülenmelidir.

## Spring Boot Kurulumu

1. Spring Boot'un bağımlılıklarını yönetmek için Maven kullanacağız. Maven projesi oluşturun.
   - Bir boş dizine gidin ve terminali açın.
   - Aşağıdaki komutu çalıştırarak yeni bir Maven projesi oluşturun:
     ```
     mvn archetype:generate -DgroupId=com.example -DartifactId=my-spring-boot-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
     ```

2. Spring Boot bağımlılığını projeye ekleyin.
   - `my-spring-boot-app` dizinine gidin.
   - `pom.xml` dosyasını bir metin düzenleyicide açın.
   - `<dependencies>` bölümüne aşağıdaki bağımlılığı ekleyin:
     ```xml
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter</artifactId>
         <version>2.5.2</version>
     </dependency>
     ```

3. Spring Boot uygulamasını çalıştırın.
   - Terminali açın ve projenin kök dizinine gidin.
   - Aşağıdaki komutu çalıştırarak uygulamayı başlatın:
     ```
     mvn spring-boot:run
     ```
   - Uygulama başarıyla başlatıldığında, terminalde bir URL görüntülenmelidir.

## Birim Testlerin Çalıştırılması

Proje, birim testlerin çalıştırılması için [JUnit](https://junit.org/junit5/) kütüphanesini kullanmaktadır. Birim testler, `src/test/java` dizini altında yer alan test sınıflarında bulunmaktadır.

Birim testlerin çalıştırılması için aşağıdaki adımları izleyebilirsiniz:

1. Proje kök dizininde bir terminal açın.
2. Aşağıdaki komutu çalıştırarak birim testleri çalıştırın:

```
mvn test
```

