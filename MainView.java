import java.util.Scanner;

public class MainView {
    private Scanner scan = new Scanner(System.in);
    private ContactList contactList;
    private UserList userList = new UserList();

    public void show() {
        boolean isLoggedIn, appRunning = true;
        int pilihan;
        int id = 0;
        String nama, username, password, phoneNumber;

        System.out.println("====================");
        System.out.println("VALENTINO HARPA\n3120500049\n2 D3 IT B\nPOST TEST PRAK. PBO");
        System.out.println("====================\n");

        while (appRunning) {
            isLoggedIn = false;

            System.out.println("Program Contact List menggunakan <ArrayList>");
            System.out.println("[1] > Log-in");
            System.out.println("[2] > Register");
            System.out.println("[3] > Exit");
            System.out.print(">> Masukkan pilihan Anda: ");
            pilihan = scan.nextInt();
            scan.nextLine();
            System.out.print("\n");

            if (pilihan == 1) {
                System.out.print("Masukkan ID user: ");
                id = scan.nextInt();
                scan.nextLine();
                System.out.print("Masukkan nama: ");
                nama = scan.nextLine();
                System.out.print("Masukkan username: ");
                username = scan.nextLine();
                System.out.print("Masukkan password: ");
                password = scan.nextLine();
                if (userList.checkUserList(id, nama, username)) {
                    if (userList.getUser(id, nama, username).checkPassword(password)) {
                        isLoggedIn = true;
                    } else
                        System.out
                                .println("Gagal login! Mohon cek password yang Anda ketik.\n");
                } else
                    System.out.println("Gagal login! Mohon cek ID, nama, username, dan password yang Anda ketik.\n");
            } else if (pilihan == 2) {
                System.out.print("Masukkan ID user: ");
                id = scan.nextInt();
                scan.nextLine();
                System.out.print("Masukkan nama: ");
                nama = scan.nextLine();
                System.out.print("Masukkan username: ");
                username = scan.nextLine();
                System.out.print("Masukkan password: ");
                password = scan.nextLine();
                System.out.print("Masukkan nomor telpon Anda: ");
                phoneNumber = scan.nextLine();
                if (!(userList.checkUserList(id, nama, username))) {
                    userList.addUser(id, nama, username, password, phoneNumber);
                    isLoggedIn = true;
                } else
                    System.out.println("Gagal register! Data user yang dimasukkan sudah ada!\n");
            } else {
                System.out.println("Terima kasih telah mencoba program ini!");
                appRunning = false;
                break;
            }

            if (isLoggedIn) {
                contactList = userList.getUser(id, nama, username).getContactList();

                while (isLoggedIn) {
                    System.out.println("\nAnda log-in sebagai: " + userList.getUser(id, nama, username).getName());
                    cetakMenu();
                    pilihan = scan.nextInt();
                    scan.nextLine();

                    switch (pilihan) {
                        case 0:
                            System.out.println("\nAnda telah berhasil logout!\n");
                            isLoggedIn = false;
                            break;
                        case 1:
                            contactList.printContacts();
                            break;
                        case 2:
                            tambahKontak();
                            break;
                        case 3:
                            perbaharuiKontak();
                            break;
                        case 4:
                            hapusKontak();
                            break;
                        case 5:
                            cariKontak();
                            break;
                        default:
                            System.out.println("\nPilihan tidak valid! Mohon coba kembali.");
                            break;
                    }
                }
            }
        }
    }

    public void cetakMenu() {
        System.out.println(
                "[0] > Keluar Aplikasi\n" +
                        "[1] > Cetak Semua Kontak\n" +
                        "[2] > Tambah Kontak Baru\n" +
                        "[3] > Perbaharui Kontak\n" +
                        "[4] > Hapus Kontak\n" +
                        "[5] > Cari Kontak\n");
        System.out.print(">> Masukkan pilihan Anda: ");
    }

    public void tambahKontak() {
        System.out.print("Masukkan ID kontak baru: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Masukkan nama kontak baru: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan nomor telpon kontak baru: ");
        String phoneNumber = scan.nextLine();
        Contact newContact = new Contact(id, nama, phoneNumber);
        if (contactList.addNewContact(newContact)) {
            System.out.println("Kontak baru ditambahkan!");
        } else {
            System.out.println("Gagal menambahkan! " + nama + " sudah ada di contact list");
        }
    }

    public void perbaharuiKontak() {
        System.out.print("Masukkan nama kontak yang sudah ada: ");
        String name = scan.nextLine();
        Contact extContact = contactList.queryContact(name);
        if (extContact == null) {
            System.out.println("Tidak dapat menemukan kontak!");
            return;
        }
        
        System.out.print("Masukkan ID kontak baru: ");
        int newId = scan.nextInt();
        scan.nextLine();
        System.out.print("Masukkan nama kontak baru: ");
        String newName = scan.nextLine();
        System.out.print("Masukkan nomor telpon kontak baru: ");
        String newPhoneNumber = scan.nextLine();

        Contact newContact = new Contact (newId, newName, newPhoneNumber);
        if (contactList.updateContact(extContact, newContact)) {
            System.out.println("Pembaharuan kontak berhasil!");
        } else {
            System.out.println("Pembaharuan kontak gagal! Mohon cek kembali");
        }
    }

    public void hapusKontak() {
        System.out.print("Masukkan nama kontak yang sudah ada: ");
        String name = scan.nextLine();
        Contact extContact = contactList.queryContact(name);
        if (extContact == null) {
            System.out.println("Gagal menemukan kontak!");
            return;
        }

        if (contactList.removeContact(extContact)) {
            System.out.println("Kontak berhasil dihapus!");
        } else {
            System.out.println("Gagal menghapus kontak!");
        }
    }

    public void cariKontak() {
        System.out.print("Masukkan nama kontak yang sudah ada: ");
        String name = scan.nextLine();
        Contact extContact = contactList.queryContact(name);
        if (extContact == null) {
            System.out.println("Tidak dapat menemukan kontak!");
            return;
        }

        System.out.println("Ditemukan!\nNama = " + extContact.getName() +
                "\nNomor Telpon: " + extContact.getPhoneNumber());
    }
}
