# Proje Dökümantasyonu

Bu dökümantasyon, projenin bağımlılıklarının nasıl yükleneceği ve birim testlerin nasıl çalıştırılacağı gibi temel bilgileri içermektedir.

## Bağımlılıkların Yüklenmesi

Projenin çalışması için aşağıdaki bağımlılıkların yüklenmesi gerekmektedir:

- [Spring Boot](https://spring.io/projects/spring-boot): Proje için temel çatıyı sağlayan Spring Boot framework'ünün bağımlılığı.
- [Lombok](https://projectlombok.org/): Java sınıflarının daha kolay bir şekilde oluşturulması için kullanılan Lombok kütüphanesinin bağımlılığı.

Bağımlılıkları yüklemek için aşağıdaki adımları izleyebilirsiniz:

1. Proje kök dizininde bir terminal açın.
2. Aşağıdaki komutu çalıştırarak bağımlılıkları yükleyin:
   
```
mvn install
```

## Birim Testlerin Çalıştırılması

Proje, birim testlerin çalıştırılması için [JUnit](https://junit.org/junit5/) kütüphanesini kullanmaktadır. Birim testler, `src/test/java` dizini altında yer alan test sınıflarında bulunmaktadır.

Birim testlerin çalıştırılması için aşağıdaki adımları izleyebilirsiniz:

1. Proje kök dizininde bir terminal açın.
2. Aşağıdaki komutu çalıştırarak birim testleri çalıştırın:

```
mvn test
```