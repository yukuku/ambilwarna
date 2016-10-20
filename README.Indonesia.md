Android Color Picker
====================

[! [Maven Central] (https://maven-badges.herokuapp.com/maven-central/com.github.yukuku/ambilwarna/badge.svg)] (https://maven-badges.herokuapp.com/maven-central/com.github.yukuku/ambilwarna)

alias 'AmbilWarna' library ("memilih warna" dalam bahasa Indonesia)

pindah dari http://code.google.com/p/yuku-android-util/

Ini adalah sebuah perpustakaan kecil untuk aplikasi Anda untuk memungkinkan pengguna untuk memilih warna yang sewenang-wenang. Hal ini digunakan dalam aplikasi Alkitab gratis untuk Android (http://www.bibleforandroid.com).

Hal ini juga digunakan oleh:
* 1.000.000 + download app <a href='http://www.davidgoemans.com/mainsite/node/26'> DigiClock Widget</a>
* 100.000 + download app <a href='https://play.google.com/store/apps/details?id=kenyu73.bannerwidget'> Banner</a>
* 10.000 + download app <a href='https://play.google.com/store/apps/details?id=net.redwarp.widget.memento'> kenang-kenangan</a>

Jika aplikasi Anda memiliki fitur untuk menyesuaikan warna beberapa latar belakang, teks, atau mungkin untuk aplikasi lukisan dimana pengguna dapat memilih warna yang berbeda untuk lukisan atau mengisi, maka 'AmbilWarna' cocok untuk Anda.


Menambahkannya ke proyek Anda
===========

dependencies {
    compile 'com.github.yukuku:ambilwarna:2.0.1'
}

Screenshot
===========

< img src = 'http://lh5.ggpht.com/_ODdyLCCXPpQ/TKsFBMSlhdI/AAAAAAAAu6o/vqpGqyCnywY/s800/r230-ambilwarna.png' >


Bagaimana menggunakan dialog
=====================

Membuat warna picker dialog dengan memanggil constructor berikut, dan kemudian menunjukkan hal itu.

AmbilWarnaDialog(Context context, int color, OnAmbilWarnaListener listener)

Alpha juga didukung oleh melewati parameter ke-3 'supportsAlpha':

AmbilWarnaDialog(Context context, int color, boolean supportsAlpha, OnAmbilWarnaListener listener)

Contoh:

initialColor adalah warna awalnya dipilih akan ditampilkan dalam persegi panjang di sebelah kiri panah.
sebagai contoh, 0xff000000 hitam, 0xff0000ff biru. Harap berhati-hati dari 0xff awal yang merupakan Alfa.
AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, initialColor, new OnAmbilWarnaListener() {
    @Override
    public void onOk(AmbilWarnaDialog dialog, int color) {
        // color is the color selected by the user.
    }

    @Override
    public void onCancel(AmbilWarnaDialog dialog) {
        // cancel was selected by the user
    }

dialog.show();

Cara menggunakannya sebagai preferensi
=============================

! [] (http://s11.postimg.org/sfn41uh43/img.png)

Sangat sederhana. Bekerja seperti 'DialogPreference' yang menyimpan Integer ke file bersama preferensi.

Hanya Tambahkan baris berikut ke file xml preferensi.

< yuku.ambilwarna.widget.AmbilWarnaPreference
Android: kunci = "your_preference_key"
Android: defaultValue = "0xff6699cc"
Android: judul = "Pilih warna" / >

Untuk mengaktifkan alpha, Gunakan atribut aplikasi 'supportsAlpha', sebagai berikut:

< PreferenceScreen
xmlns:Android = "http://schemas.android.com/apk/res/android"
xmlns:App = "http://schemas.android.com/apk/res-auto" >

< yuku.ambilwarna.widget.AmbilWarnaPreference
Android: kunci = "your_preference_key"
Android: defaultValue = "0xff6699cc"
App:supportsAlpha = "true"
Android: judul = "Pilih warna dengan alpha" / >
</PreferenceScreen>

Kontributor
============

* Pascal Cans (noobs.com)
* Justin Warner (satu Rainboot Studio)
