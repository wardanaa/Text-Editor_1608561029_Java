/*
1 * Nama: I Made Wardana
 * NIM : 1608561029
 * Mata Kuliah: Praktikum Struktur Data
 * Deskripsi: Program ini menyimulasikan aplikasi editor teks.
 */

package text_editor_package;

import java.util.Scanner;

public class TextEditor
{
    class node	//Class node pada linked list
    {
	    String huruf;
	    node next;
	    node prev;
        public void insert(String huruf)
        {
            this.huruf = huruf;
        }
        public String getHuruf()
        {
        	return this.huruf;
        }
    }

    node head = null, tail = null, baru, temp, cetak, del, after, before = null;
    
    public void tambah()	//Function add karakter
    {
        System.out.print("Masukkan sebuah karakter\t:");
        Scanner input = new Scanner (System.in);
        String huruf;
        huruf = input.next();
        baru = new node();
        baru.insert(huruf);
        
        baru.next = null;
        
        if(head == null)	//Kondisi tidak ada node pada linked list
        {
	        head = baru;
	        tail = baru;
	        temp = baru;
	        head.next = null;
	        before = new node();
	        head.prev = before;
	        before.next = head;
	        before.prev = null;
        }
        
        else if (temp.next == null)	//Kondisi linked list telah ada dan pointer berada paling kanan
        {
	        temp.next = baru;
	        tail = baru;
	        tail.prev = temp;
	        temp = baru;
        }
        
        else if (temp.prev == null)	//Kondisi linked list telah ada dan pointer berada paling kiri
        {
	        head.prev = baru;
	        before.next = baru;
	        baru.prev = before;
	        baru.next = head;
	        head = baru;
	        temp = head;
	        before.prev = null;
        }
        
        else	//Kondisi linked list telah ada dan pointer tidak berada di paling kiri maupun paling kanan
        {
	        after = temp.next;
	        temp.next = baru;
	        after.prev = baru;
	        baru.next = after;
	        baru.prev = temp;
	        temp = baru;
        }
        
        System.out.println("\nPress any key to continue...");
    }
    
    
    void hapus()    //Function penghapusan karakter
    {
        if(temp == before) //Kondisi tidak ada node pada linked list yang dapat dihapus
        {
            System.out.print("\nMaaf, tidak ada karakter yang dapat dihapus!\n");
        }

        else if(head==tail)	//Kondisi hanya ada satu node pada linked list
        {
            del = head;
            temp = before;
            System.out.print("\nKarakter " +del.getHuruf()+" berhasil dihapus!\n");
            del = null;
            head = null;
        }
        
        else if(temp.next == null)	//Kondisi node yang akan dihapus berada paling kiri
        {
            tail = tail.prev;
            del = temp;
            temp = temp.prev;
            System.out.print("\nKarakter "+del.getHuruf()+" berhasil dihapus!\n");
            del = null;
            tail.next = null;
        }

        else if(temp == head)		//Kondisi node yang akan dihapus berada paling kanan
        {
            del = head;
            temp = before;
            head = head.next;
            System.out.print("\nKarakter "+del.getHuruf()+" berhasil dihapus!\n");
            del = null;
            temp.next = head;
            head.prev = before;
        }

        else	//Kondisi node yang akan dihapus berada di antara node lain
        {
            del = temp;
            temp = temp.prev;
            del.next.prev = temp;
            temp.next = del.next;
            System.out.print("\nKarakter "+del.getHuruf()+" berhasil dihapus!\n");
            del = null;
        }

        System.out.print("\nPress any key to continue...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    
    void shift_left()   //Function pergeseran pointer ke kiri
    {
        if(temp == before)    //Kondisi pointer menunjuk node paling kiri, sehingga tidak dimungkinkan menggeser ke kiri lagi
        {
            System.out.print("\nMaaf, pointer telah berada paling kiri!\n");
        }
        else//Kondisi pointer menunjuk node yang tidak paling kiri, sehingga pointer masih bisa digeser ke kiri
        {
	        System.out.print("\nPointer berhasil digeser ke kiri!\n");
	        temp = temp.prev;
        }
        System.out.print("\nPress any key to continue...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    
    void shift_right()   //Function pergeseran pointer ke kanan
    {
        if(temp == tail)    //Kondisi pointer menunjuk node paling kanan, sehingga tidak dimungkinkan menggeser ke kanan lagi
        {
            System.out.print("\nMaaf, pointer telah berada paling kanan!\n");
        }
        else    //Kondisi pointer menunjuk node yang tidak paling kanan, sehingga pointer masih bisa digeser ke kanan
        {
            System.out.print("\nPointer berhasil digeser ke kanan!\n");
            temp = temp.next;
        }
        System.out.print("\nPress any key to continue...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    
    void print()    //Function mencetak karakter terkini
    {
        if(head != null)    //Kondisi terdapat node pada linked list
        {
            cetak = head;
            while(cetak != null)
            {
                System.out.print(cetak.getHuruf());
                cetak = cetak.next;
            }
        }
        else    //Kondisi linked list kosong
        {
            System.out.print("\nMaaf, tidak ada karakter yang dapat ditampilkan!\n");
        }
        System.out.print("\nPress any key to continue...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    
    public static void main(String[] args)
    {
    	TextEditor akses = new TextEditor();
        int a, i, pilih;
        System.out.println("Program Text Editor\n-------------------\n\n");
        System.out.print("Masukkan jumlah perintah: ");
        Scanner input = new Scanner (System.in);
        a = input.nextInt();
        for(i = 0; i < a; i++)
        {
            System.out.print("ke-"+(i+1)+"\nMenu:\n");
            System.out.print("1. Cetak seluruh karakter\n2. Tambah karakter\n3. Hapus karakter\n4. Geser ke kiri\n5. Geser ke kanan\n6. Keluar dari program\n");
            System.out.print("Masukkan pilihan Anda: ");
            Scanner pil = new Scanner (System.in);
            pilih = pil.nextInt();
            switch(pilih)
            {
                case 1:
                    akses.print();
                    break;
                case 2:
                	akses.tambah();
                	break;
                case 3:
                	akses.hapus();
                	break;
                case 4:
                	akses.shift_left();
                	break;
                case 5:
                	akses.shift_right();
                	break;
                case 6:
                	System.exit(0);
                    break;
                default:
                	System.out.print("\nMaaf, inputan salah!\nPress any key to continue...");
                    Scanner pause = new Scanner (System.in);
                    pause.nextLine();
                    break;
            }
            //System("cls");
            a++;
        }
        System.exit(0);
    }
}
   