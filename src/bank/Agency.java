package bank;

public interface Agency {

   public void accountNew(int agencyNum);
   public void depositNew(int depositValue);
   public boolean transferNew(int transferValue, int targetNumberAcc);


}
