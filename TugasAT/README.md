# Nama Project
Automation Testing W3Schools (Selenium + Java)

## Deskripsi
Project ini menguji bebarapa fitur basic yang ada pada laman website tersebut
diantaranya :
- Search bar
- Try it Yourself

## Website yang Diuji
https://www.w3schools.com/

## Skenario Pengujian
| No | Skenario | Langkah Singkat | Hasil yang Diharapkan |
|----|----------|-----------------|-----------------------|
| 1  | Menjalankan kode Java di Try it Yourself | Buka tutorial Java, klik Try it Yourself, klik Run | Output kode muncul di panel hasil |
| 2  | (skenario gagal) Cari materi yang tidak ada | Ketik kata acak di pencarian | Pesan "tidak ditemukan" muncul |

## Teknologi
- Java (JDK 21)
- Selenium WebDriver 4.x
- Google Chrome
- VS Code

## Cara Menjalankan
1. Install JDK dan Google Chrome
2. Install selenium
3. tambahkan selenium kedalam file 'lib'
4. Clone atau download project ini
5. Jalankan class `Scenario3` (atau class skenario lain)

## Catatan
- Pengujian dilakukan pada website produksi, bukan demo (ada kemungkinan website diupdate dan code ini sudah tidak berjalan)
- Script tidak mengirim data sensitif atau melakukan transaksi

## Scenario 1
Verify that the user can search for a tutorial successfully.
## Scenario 2
Verify that the website displays an error message when searching for a nonexisting tutorial.
## Scenario 3
Verify that user can try "Try it yourself"  feature.
