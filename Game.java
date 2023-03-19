import java.util.Scanner;

public class Game {

public void oyunBaslat() {
	
	Piyon p1 = new Piyon("siyah", 1);
	Piyon p2 = new Piyon("siyah", 1);
	Piyon p3 = new Piyon("siyah", 1);
	Piyon p4 = new Piyon("siyah", 1);
	Piyon p5 = new Piyon("siyah", 1);
	Piyon p6 = new Piyon("siyah", 1);
	Piyon p7 = new Piyon("siyah", 1);
	Piyon p8 = new Piyon("siyah", 1);
	
	Piyon P1 = new Piyon("beyaz", 1);
	Piyon P2 = new Piyon("beyaz", 1);
	Piyon P3 = new Piyon("beyaz", 1);
	Piyon P4 = new Piyon("beyaz", 1);
	Piyon P5 = new Piyon("beyaz", 1);
	Piyon P6 = new Piyon("beyaz", 1);
	Piyon P7 = new Piyon("beyaz", 1);
	Piyon P8 = new Piyon("beyaz", 1);
	
	Kale k1 = new Kale("siyah", 5);
	Kale k2 = new Kale("siyah", 5);
	Kale K1 = new Kale("beyaz", 5);
	Kale K2 = new Kale("beyaz", 5);
	
	At a1 = new At("siyah", 3);
	At a2 = new At("siyah", 3);
	At A1 = new At("beyaz", 3);
	At A2 = new At("beyaz", 3);
	
	Fil f1 = new Fil("siyah", 3);
	Fil f2 = new Fil("siyah", 3);
	Fil F1 = new Fil("beyaz", 3);
	Fil F2 = new Fil("beyaz", 3);
	
	Vezir v1 = new Vezir("siyah", 9);
	Vezir V1 = new Vezir("beyaz", 9);
	
	Sah s1 = new Sah("siyah", 40);
	Sah S1 = new Sah("beyaz", 40);
	
	Item bos = new Item("-");
	
	Item[][] tahta = {
			{P1, P2, P3, P4, P5, P6, P7, P8},
			{K1, A1, F1, V1, S1, F2, A2, K2},
			{bos, bos, bos, bos, bos, bos, bos, bos},
			{bos, bos, bos, bos, bos, bos, bos, bos},
			{bos, bos, bos, bos, bos, bos, bos, bos},
			{bos, bos, bos, bos, bos, bos, bos, bos},
			{k1, a1, f1, v1, s1, f2, a2, k2},
			{p1, p2, p3, p4, p5, p6, p7, p8}	
	};
	
	Board board = new Board(tahta);
	Board yedekBoard = new Board(tahta);

	board.getOyunTahtasi();
	
	Player player1 = new Player("siyah");
	Player PLAYER2 = new Player("beyaz");
	
	Scanner keyboard = new Scanner(System.in);
	int oyuncuSirasi = 0;
	
	while(true) {
		
		if(oyuncuSirasi % 2 == 0) 
			System.out.println("Sira Beyazda. Oynamak istediginiz tasin koordinatini ve tasi koymak istediginiz koordinati giriniz");
		else 
			System.out.println("Sira Siyahta. Oynamak istediginiz tasin koordinatini ve tasi koymak istediginiz koordinati giriniz");
		
		String input = keyboard.nextLine();
				
		if(input.equals("exit")) {
			System.out.println("Siyah oyuncunun puani: " + player1.getPuan());
			System.out.println("Beyaz oyuncunun puani: " + PLAYER2.getPuan());
			System.out.println("Oyun kapatiliyor.");
			break;
		}
		
		if( input.charAt(0) < 97 || input.charAt(0) > 104 || input.charAt(3) < 97 || input.charAt(3) > 104 || input.charAt(1) < 49 || input.charAt(1) > 56 || input.charAt(4) < 49 || input.charAt(4) > 56 ) {
			System.out.println("Hatali girdi.");
			continue;
		}
			
		
		
		
		int ilkSutunAlici = Integer.valueOf(input.charAt(1))-49;
		int sonSutunAlici = Integer.valueOf(input.charAt(4))-49;

		
	if(oyuncuSirasi % 2 == 0)	{

		if(hamleYap(input, PLAYER2, ilkSutunAlici, sonSutunAlici, board) == "Hatali girdi.") {
			System.out.println("Hatali girdi. Sira tekrar size aktariliyor.");
			continue;
		}
	}
		
		else  {
			if(hamleYap(input, player1, ilkSutunAlici, sonSutunAlici, board) == "Hatali girdi.") {
				System.out.println("Hatali girdi. Sira tekrar size aktariliyor.");
				continue;
			}		
		}
			
	board.getOyunTahtasi();
	System.out.println("Tahta sola kaydiriliyor.");
	board.solaKaydirma();
	board.getOyunTahtasi();
	
		if( player1.puan >= 39) {
			System.out.println("Beyaz taraf puan olarak kazanamayacak duruma geldi veya sahini kaybetti. Oyunu siyah kazandi.");
			System.out.println("1. Oyuncunun puani: " + player1.getPuan());
			System.out.println("2. Oyuncunun puani: " + PLAYER2.getPuan());
			break;
		}
		
		if( PLAYER2.puan >= 39) {
			System.out.println("Siyah taraf puan olarak kazanamayacak duruma geldi veya sahini kaybetti. Oyunu beyaz kazandi.");
			System.out.println("1. Oyuncunun puani: " + player1.getPuan());
			System.out.println("2. Oyuncunun puani: " + PLAYER2.getPuan());
			break;
		}
			
		oyuncuSirasi++;
		
		
	}
	
	
	
}
	
//----------------------------------------------------------------------

public static boolean hamleKontrol(int baslangicSatir, int baslangicSutun, int hedefSatir, int hedefSutun, Board board, Player player) {
	
	int dogrulama = 0;
	
	if( baslangicSatir >= 0 && baslangicSatir <= 7 && baslangicSutun >= 0 && baslangicSutun <= 7 && hedefSatir >= 0 && hedefSatir <= 7 && hedefSutun >= 0 && hedefSutun <= 7 ) 
	{
		dogrulama++;
		if( board.oyunTahtasi[baslangicSatir][baslangicSutun].amblem != "-" ) {
			dogrulama++;
		}
		if ( player.renk == board.oyunTahtasi[baslangicSatir][baslangicSutun].renk ) {
			dogrulama++;
		}
		if( board.oyunTahtasi[baslangicSatir][baslangicSutun].hareketKabiliyeti(baslangicSatir, baslangicSutun, hedefSatir, hedefSutun, board, player) ) {
			dogrulama++;
		}
		if( board.oyunTahtasi[baslangicSatir][baslangicSutun].renk != board.oyunTahtasi[hedefSatir][hedefSutun].renk ) {
			player.addPuan(board.oyunTahtasi[hedefSatir][hedefSutun].puan);
			dogrulama++;
		}
		

	}
	
	
if(dogrulama == 5) {
	player.tasOyna(baslangicSatir, baslangicSutun, hedefSatir, hedefSutun, board);
	return true;
}
	else
	return false;
}
	
//----------------------------------------------------------------------	
	
	
public static String hamleYap(String input, Player player, int ilkSutunAlici, int sonSutunAlici, Board board) {
	
	if(input.charAt(0) == 'a') {

		if(input.charAt(3) == 'a') {
			if( hamleKontrol(0, ilkSutunAlici, 0, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
				return "Hamle oynandi.";
			}
			else {
				return "Hatali girdi.";
			}
				
		}
		
		if(input.charAt(3) == 'b') {
			if( hamleKontrol(0, ilkSutunAlici, 1, sonSutunAlici, board, player) ) {
			System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
			else {
				return "Hatali girdi.";
			}
		}
		
		if(input.charAt(3) == 'c') {
			if( hamleKontrol(0, ilkSutunAlici, 2, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'd') {
			if( hamleKontrol(0, ilkSutunAlici, 3, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
				return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'e') {
			if( hamleKontrol(0, ilkSutunAlici, 4, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'f') {
			if( hamleKontrol(0, ilkSutunAlici, 5, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'g') {
			if( hamleKontrol(0, ilkSutunAlici, 6, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
		}
		
		if(input.charAt(3) == 'h') {
			if( hamleKontrol(0, ilkSutunAlici, 7, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
		}
		
	}
	
//----------
	
	if(input.charAt(0) == 'b') {
		
		if(input.charAt(3) == 'a') {
			if( hamleKontrol(1, ilkSutunAlici, 0, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
				return "Hamle oynandi.";
			}
			else {
				return "Hatali girdi.";
			}
				
		}
		
		if(input.charAt(3) == 'b') {
			if( hamleKontrol(1, ilkSutunAlici, 1, sonSutunAlici, board, player) ) {
			System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
			else {
				return "Hatali girdi.";
			}
		}
		
		if(input.charAt(3) == 'c') {
			if( hamleKontrol(1, ilkSutunAlici, 2, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'd') {
			if( hamleKontrol(1, ilkSutunAlici, 3, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
				return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'e') {
			if( hamleKontrol(1, ilkSutunAlici, 4, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'f') {
			if( hamleKontrol(1, ilkSutunAlici, 5, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'g') {
			if( hamleKontrol(1, ilkSutunAlici, 6, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
		}
		
		if(input.charAt(3) == 'h') {
			if( hamleKontrol(1, ilkSutunAlici, 7, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
		}
		
	}

//-------------		
	
	if(input.charAt(0) == 'c') {
		
		if(input.charAt(3) == 'a') {
			if( hamleKontrol(2, ilkSutunAlici, 0, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
				return "Hamle oynandi.";
			}
			else {
				return "Hatali girdi.";
			}
				
		}
		
		if(input.charAt(3) == 'b') {
			if( hamleKontrol(2, ilkSutunAlici, 1, sonSutunAlici, board, player) ) {
			System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
			else {
				return "Hatali girdi.";
			}
		}
		
		if(input.charAt(3) == 'c') {
			if( hamleKontrol(2, ilkSutunAlici, 2, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'd') {
			if( hamleKontrol(2, ilkSutunAlici, 3, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
				return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'e') {
			if( hamleKontrol(2, ilkSutunAlici, 4, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'f') {
			if( hamleKontrol(2, ilkSutunAlici, 5, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'g') {
			if( hamleKontrol(2, ilkSutunAlici, 6, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
		}
		
		if(input.charAt(3) == 'h') {
			if( hamleKontrol(2, ilkSutunAlici, 7, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
		}
		
	}

//----------------		
	
	if(input.charAt(0) == 'd') {
		
		if(input.charAt(3) == 'a') {
			if( hamleKontrol(3, ilkSutunAlici, 0, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
				return "Hamle oynandi.";
			}
			else {
				return "Hatali girdi.";
			}
				
		}
		
		if(input.charAt(3) == 'b') {
			if( hamleKontrol(3, ilkSutunAlici, 1, sonSutunAlici, board, player) ) {
			System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
			else {
				return "Hatali girdi.";
			}
		}
		
		if(input.charAt(3) == 'c') {
			if( hamleKontrol(3, ilkSutunAlici, 2, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'd') {
			if( hamleKontrol(3, ilkSutunAlici, 3, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
				return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'e') {
			if( hamleKontrol(3, ilkSutunAlici, 4, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'f') {
			if( hamleKontrol(3, ilkSutunAlici, 5, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'g') {
			if( hamleKontrol(3, ilkSutunAlici, 6, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
		}
		
		if(input.charAt(3) == 'h') {
			if( hamleKontrol(3, ilkSutunAlici, 7, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
		}
		
	}
	
//---------------
	
	if(input.charAt(0) == 'e') {
		
		if(input.charAt(3) == 'a') {
			if( hamleKontrol(4, ilkSutunAlici, 0, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
				return "Hamle oynandi.";
			}
			else {
				return "Hatali girdi.";
			}
				
		}
		
		if(input.charAt(3) == 'b') {
			if( hamleKontrol(4, ilkSutunAlici, 1, sonSutunAlici, board, player) ) {
			System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
			else {
				return "Hatali girdi.";
			}
		}
		
		if(input.charAt(3) == 'c') {
			if( hamleKontrol(4, ilkSutunAlici, 2, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'd') {
			if( hamleKontrol(4, ilkSutunAlici, 3, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
				return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'e') {
			if( hamleKontrol(4, ilkSutunAlici, 4, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'f') {
			if( hamleKontrol(4, ilkSutunAlici, 5, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'g') {
			if( hamleKontrol(4, ilkSutunAlici, 6, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
		}
		
		if(input.charAt(3) == 'h') {
			if( hamleKontrol(4, ilkSutunAlici, 7, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
		}
		
	}

//-----------		
	
	if(input.charAt(0) == 'f') {
		
		if(input.charAt(3) == 'a') {
			if( hamleKontrol(5, ilkSutunAlici, 0, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
				return "Hamle oynandi.";
			}
			else {
				return "Hatali girdi.";
			}
				
		}
		
		if(input.charAt(3) == 'b') {
			if( hamleKontrol(5, ilkSutunAlici, 1, sonSutunAlici, board, player) ) {
			System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
			else {
				return "Hatali girdi.";
			}
		}
		
		if(input.charAt(3) == 'c') {
			if( hamleKontrol(5, ilkSutunAlici, 2, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'd') {
			if( hamleKontrol(5, ilkSutunAlici, 3, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
				return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'e') {
			if( hamleKontrol(5, ilkSutunAlici, 4, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'f') {
			if( hamleKontrol(5, ilkSutunAlici, 5, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'g') {
			if( hamleKontrol(5, ilkSutunAlici, 6, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
		}
		
		if(input.charAt(3) == 'h') {
			if( hamleKontrol(5, ilkSutunAlici, 7, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
		}
		
	}

//--------------		
	
	if(input.charAt(0) == 'g') {
		
		if(input.charAt(3) == 'a') {
			if( hamleKontrol(6, ilkSutunAlici, 0, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
				return "Hamle oynandi.";
			}
			else {
				return "Hatali girdi.";
			}
				
		}
		
		if(input.charAt(3) == 'b') {
			if( hamleKontrol(6, ilkSutunAlici, 1, sonSutunAlici, board, player) ) {
			System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
			else {
				return "Hatali girdi.";
			}
		}
		
		if(input.charAt(3) == 'c') {
			if( hamleKontrol(6, ilkSutunAlici, 2, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'd') {
			if( hamleKontrol(6, ilkSutunAlici, 3, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
				return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'e') {
			if( hamleKontrol(6, ilkSutunAlici, 4, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'f') {
			if( hamleKontrol(6, ilkSutunAlici, 5, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'g') {
			if( hamleKontrol(6, ilkSutunAlici, 6, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
		}
		
		if(input.charAt(3) == 'h') {
			if( hamleKontrol(6, ilkSutunAlici, 7, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
		}
		
	}

//-----------------		
	
	if(input.charAt(0) == 'h') {
		
		if(input.charAt(3) == 'a') {
			if( hamleKontrol(7, ilkSutunAlici, 0, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
				return "Hamle oynandi.";
			}
			else {
				return "Hatali girdi.";
			}
				
		}
		
		if(input.charAt(3) == 'b') {
			if( hamleKontrol(7, ilkSutunAlici, 1, sonSutunAlici, board, player) ) {
			System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
			else {
				return "Hatali girdi.";
			}
		}
		
		if(input.charAt(3) == 'c') {
			if( hamleKontrol(7, ilkSutunAlici, 2, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'd') {
			if( hamleKontrol(7, ilkSutunAlici, 3, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
				return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'e') {
			if( hamleKontrol(7, ilkSutunAlici, 4, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'f') {
			if( hamleKontrol(7, ilkSutunAlici, 5, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
			}
		
		if(input.charAt(3) == 'g') {
			if( hamleKontrol(7, ilkSutunAlici, 6, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
		}
		
		if(input.charAt(3) == 'h') {
			if( hamleKontrol(7, ilkSutunAlici, 7, sonSutunAlici, board, player) ) {
				System.out.println("Hamle oynandi.");
			return "Hamle oynandi.";
			}
				else {
		return "Hatali girdi.";
				}
		}
		
	}
	return "a";
}
	
	
	
	
}
