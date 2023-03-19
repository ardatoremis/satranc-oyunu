
public class Piyon extends Item{

	public Piyon(String renk, int puan) {
		this.renk = renk;
		if(renk == "siyah")
			this.amblem = "p";
		else
			this.amblem = "P";
		this.puan = puan;
	}
	
	public boolean hareketKabiliyeti(int baslangicSatir, int baslangicSutun, int hedefSatir, int hedefSutun, Board board, Player player) {
		
		if( board.oyunTahtasi[hedefSatir][hedefSutun].amblem == "-" && ( (player.renk == "beyaz" && hedefSatir == baslangicSatir+1) || (player.renk == "siyah" && hedefSatir == baslangicSatir-1) ) ) {
			return true;
		}
		
else	if( board.oyunTahtasi[hedefSatir][hedefSutun].amblem != "-" && ( ( player.renk == "beyaz" && hedefSatir == baslangicSatir+1 && (hedefSutun == baslangicSutun-1 || hedefSutun == baslangicSutun+1) ) || ( player.renk == "siyah" && hedefSatir == baslangicSatir-1 && (hedefSutun == baslangicSutun-1 || hedefSutun == baslangicSutun+1) ) ) )
			return true;
		
		else	
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
