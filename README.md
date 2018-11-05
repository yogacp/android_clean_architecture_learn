
# Learn Clean Architecture in Android

Initial Project untuk belajar tentang Clean Architecture di Aplikasi Android, untuk penjelasan lebih lanjut, bisa baca artikel saya di Medium:  [Android Clean Architecture Using Kotlin](https://medium.com/@yogacp/android-clean-architecture-using-kotlin-48306644ada7)

## Layers Structure

Dalam penerapannya, mungkin bisa berbeda-beda setiap orang, Tapi untuk _starting point,_ Saya menggunakan 5 _Layers_ seperti dibawah ini:

|Layers                |Entity                   |
|----------------|-------------------------------|
|Domain          |`Router, Usecases`             |
|Data            |`Databases Model, Responses, Network Repository`|
|Presentation    |`View`                         |
|External        |`Helper Class, Extension Functions, Adapter, Etc`|


## Project Diagrams

Untuk mempermudah dalam memahami project structure diatas, berikut project diagramnya:
![Project diagram](https://snag.gy/4oV3hl.jpg)