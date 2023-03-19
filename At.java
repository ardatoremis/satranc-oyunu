
public class At extends Item{

	public At(String renk, int puan) {
		this.renk = renk;
		if(renk == "siyah")
			this.amblem = "a";
		else
			this.amblem = "A";
		this.puan = puan;
	}

	public boolean hareketKabiliyeti(int baslangicSatir, int baslangicSutun, int hedefSatir, int hedefSutun, Board board, Player player) {
		
		if( (hedefSatir == baslangicSatir+2 && hedefSutun == baslangicSutun-1) || (hedefSatir == baslangicSatir+2 && hedefSutun == baslangicSutun+1) || (hedefSatir == baslangicSatir-2 && hedefSutun == baslangicSutun-1) || (hedefSatir == baslangicSatir-2 && hedefSutun == baslangicSutun+1) || (hedefSatir == baslangicSatir+1 && hedefSutun == baslangicSutun-2) || (hedefSatir == baslangicSatir+1 && hedefSutun == baslangicSutun+2) || (hedefSatir == baslangicSatir-1 && hedefSutun == baslangicSutun-2) || (hedefSatir == baslangicSatir-1 && hedefSutun == baslangicSutun+2)  )
			return true;
		else
			return false;
	}
	
	
	
}
