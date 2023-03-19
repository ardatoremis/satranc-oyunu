
public class Board {

	Item[][] oyunTahtasi;
	
//----------------------------------------------------------------------

	public Board(Item[][] tahta) {
		this.oyunTahtasi = tahta;
	}

//----------------------------------------------------------------------	
	
	public void getOyunTahtasi() {
		System.out.println("  1 2 3 4 5 6 7 8");
		for(int i=0; i < oyunTahtasi.length; i ++) {
				if(i == 0) {
				System.out.print("a ");
				for(int k=0; k<8; k++) {
				System.out.print(oyunTahtasi[i][k].amblem + " "); 
				}
			}	
				if(i == 1) {
				System.out.print("b ");
				for(int k=0; k<8; k++) {
				System.out.print(oyunTahtasi[i][k].amblem + " "); 
				}	
			}	
				if(i == 2) {
				System.out.print("c ");
				for(int k=0; k<8; k++) {
				System.out.print(oyunTahtasi[i][k].amblem + " "); 
				}
			}	
				if(i == 3) {
				System.out.print("d ");
				for(int k=0; k<8; k++) {
				System.out.print(oyunTahtasi[i][k].amblem + " "); 
				}
			}	
				if(i == 4) {
				System.out.print("e ");
				for(int k=0; k<8; k++) {
				System.out.print(oyunTahtasi[i][k].amblem + " "); 
				}
			}	
				if(i == 5) {
				System.out.print("f ");
				for(int k=0; k<8; k++) {
				System.out.print(oyunTahtasi[i][k].amblem + " "); 
				}
			}	
				if(i == 6) {
				System.out.print("g ");
				for(int k=0; k<8; k++) {
				System.out.print(oyunTahtasi[i][k].amblem + " "); 
				}
			}
				if(i == 7) {
				System.out.print("h ");
				for(int k=0; k<8; k++) {
				System.out.print(oyunTahtasi[i][k].amblem + " "); 
				}
			}
			System.out.println();
		}	
	}
	
//----------------------------------------------------------------------
	
	public void solaKaydirma() {
		
		for(int i=0; i < this.oyunTahtasi.length; i++) {
			int sayac = 0;
			Item temp = oyunTahtasi[i][0];
			
			for(int k=0; k < 7; k++) {
				oyunTahtasi[i][k] = oyunTahtasi[i][k+1];
				sayac++;
			}
			oyunTahtasi[i][sayac] = temp;
			sayac = 0;
		}	
	}
	
	
	
	
	
	
}
