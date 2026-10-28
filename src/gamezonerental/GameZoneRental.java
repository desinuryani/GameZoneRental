import java.util.Scanner;

public class GameZoneRental {

    static Scanner input = new Scanner(System.in);

    // Method untuk menampilkan judul program
    public static void tampilkanJudul() {
        System.out.println("====================================");
        System.out.println("         GAMEZONE RENTAL PS");
        System.out.println("====================================");
    }

    // Method untuk melakukan transaksi penyewaan
    public static void transaksi() {

        String nama;
        String konsol;
        String tambahMinuman;
        int pilihan;
        int durasi;
        int hargaSewa;
        int biayaSewa;
        int diskon;
        int biayaMinuman;
        int totalBayar;

        tampilkanJudul();

        // Input nama pelanggan
        System.out.print("Nama Pelanggan : ");
        nama = input.nextLine();

        // Memilih konsol PlayStation
        do {
            System.out.println("\nPilihan Konsol:");
            System.out.println("1. PlayStation 4 - Rp8000/jam");
            System.out.println("2. PlayStation 5 - Rp12000/jam");
            System.out.print("Pilihan         : ");

            while (!input.hasNextInt()) {
                System.out.println("Pilihan harus berupa angka!");
                input.nextLine();
                System.out.print("Pilihan         : ");
            }

            pilihan = input.nextInt();
            input.nextLine();

            if (pilihan != 1 && pilihan != 2) {
                System.out.println("Pilihan tidak tersedia!");
            }

        } while (pilihan != 1 && pilihan != 2);

        // Menentukan konsol dan harga sewa
        if (pilihan == 1) {
            konsol = "PlayStation 4";
            hargaSewa = 8000;
        } else {
            konsol = "PlayStation 5";
            hargaSewa = 12000;
        }

        // Input durasi bermain
        do {
            System.out.print("Lama Bermain    : ");

            while (!input.hasNextInt()) {
                System.out.println("Durasi harus berupa bilangan bulat!");
                input.nextLine();
                System.out.print("Lama Bermain    : ");
            }

            durasi = input.nextInt();
            input.nextLine();

            if (durasi <= 0) {
                System.out.println("Durasi harus lebih dari 0 jam!");
            }

        } while (durasi <= 0);

        // Menghitung biaya sewa
        biayaSewa = hargaSewa * durasi;

        // Menghitung diskon 10% jika bermain minimal 3 jam
        if (durasi >= 3) {
            diskon = biayaSewa * 10 / 100;
        } else {
            diskon = 0;
        }

        // Menawarkan minuman tambahan
        do {
            System.out.print("Tambah Minuman (Y/T): ");
            tambahMinuman = input.nextLine();

            if (!tambahMinuman.equalsIgnoreCase("Y")
                    && !tambahMinuman.equalsIgnoreCase("T")) {
                System.out.println("Masukkan Y untuk Ya atau T untuk Tidak!");
            }

        } while (!tambahMinuman.equalsIgnoreCase("Y")
                && !tambahMinuman.equalsIgnoreCase("T"));

        if (tambahMinuman.equalsIgnoreCase("Y")) {
            biayaMinuman = 5000;
        } else {
            biayaMinuman = 0;
        }

        // Menghitung total pembayaran
        totalBayar = biayaSewa - diskon + biayaMinuman;

        // Menampilkan struk pembayaran
        System.out.println("------------------------------------");
        System.out.println("           STRUK GAMEZONE");
        System.out.println("------------------------------------");
        System.out.println("Pelanggan       : " + nama);
        System.out.println("Konsol          : " + konsol);
        System.out.println("Durasi          : " + durasi + " jam");
        System.out.println("Biaya Sewa      : Rp" + biayaSewa);
        System.out.println("Diskon (10%)    : Rp" + diskon);
        System.out.println("Minuman         : Rp" + biayaMinuman);
        System.out.println("------------------------------------");
        System.out.println("TOTAL BAYAR     : Rp" + totalBayar);
        System.out.println("====================================");
    }

    // Method utama program
    public static void main(String[] args) {

        String ulang;

        do {
            transaksi();

            System.out.print("\nTransaksi Baru (Y/T): ");
            ulang = input.nextLine();

            while (!ulang.equalsIgnoreCase("Y")
                    && !ulang.equalsIgnoreCase("T")) {
                System.out.println("Masukkan Y untuk Ya atau T untuk Tidak!");
                System.out.print("Transaksi Baru (Y/T): ");
                ulang = input.nextLine();
            }

            System.out.println();

        } while (ulang.equalsIgnoreCase("Y"));

        System.out.println("Terima kasih telah menggunakan GameZone!");

        input.close();
    }
}
