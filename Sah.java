
public class Sah extends Item{

	public Sah(String renk, int puan) {
		this.renk = renk;
		if(renk == "siyah")
			this.amblem = "s";
		else
			this.amblem = "S";
		this.puan = puan;
	}

	public boolean hareketKabiliyeti(int baslangicSatir, int baslangicSutun, int hedefSatir, int hedefSutun, Board board, Player player) {
		
		if(  ( hedefSatir == baslangicSatir+1 && hedefSutun == baslangicSutun ) || ( hedefSatir == baslangicSatir-1 && hedefSutun == baslangicSutun ) || ( hedefSatir == baslangicSatir && hedefSutun == baslangicSutun+1 ) || ( hedefSatir == baslangicSatir && hedefSutun == baslangicSutun-1 ) || ( hedefSatir == baslangicSatir-1 && hedefSutun == baslangicSutun-1 ) || ( hedefSatir == baslangicSatir-1 && hedefSutun == baslangicSutun+1 ) || ( hedefSatir == baslangicSatir+1 && hedefSutun == baslangicSutun-1 ) || ( hedefSatir == baslangicSatir+1 && hedefSutun == baslangicSutun+1 ) ) {
			return true;
		}
		else	
		return false;
	}
	
	
	
	
	
	
	
	
}
