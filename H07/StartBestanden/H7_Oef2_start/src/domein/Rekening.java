package domein;

public class Rekening
{
    private long rekeningNr;
    private double saldo;
    private String houder;
    
    public Rekening(long rekeningNr, String houder)
    {
        setRekeningNr(rekeningNr);
        setHouder(houder);
    }

    
    private void setRekeningNr(long rekeningNr)
    {
        long eerste10 = rekeningNr / 100;
        int rest = (int) (rekeningNr % 100);

        if (!(eerste10 % 97 == rest || (eerste10 % 97 == 0 && rest == 97)))
        {
            throw new IllegalArgumentException("Rekeningnummer moet correct zijn");
        }
        this.rekeningNr = rekeningNr;
    }

    private void setHouder(String houder)
    {
        if (houder == null || houder.isBlank())
        {
            throw new IllegalArgumentException("Houder mag niet leeg zijn");
        }
        this.houder = houder;
    }
    
    public long getRekeningNr()
    {
        return rekeningNr;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public String getHouder()
    {
        return houder;
    }

    @Override
    public String toString()
    {
        long eerste3 = getRekeningNr() / 1000000000;
        long rest = getRekeningNr() % 100;
        long midden7 = (getRekeningNr() / 100) % 10000000;

        return String.format("%s%s %03d-%07d-%02d%n%s %s%n%s%.2f %s",
        		"Rekening", " met rekeningnummer", eerste3, midden7, rest,
                "staat op naam van", getHouder(),
                "en bevat ", getSaldo(), "euro");
    }

    public boolean stortOp(double bedrag)
    {
        if (bedrag > 0)
        {
            saldo += bedrag;
            return true;
        }
        return false;
    }

    public boolean haalAf(double bedrag)
    {
        if (bedrag > 0)
        {
            saldo -= bedrag;
            return true;
        }

        return false;
    }

    public boolean schrijfBedragOverNaar(double bedrag, Rekening naarRek)
    {
        boolean succes = false;
        if (naarRek != null && haalAf(bedrag))
        {
            succes = naarRek.stortOp(bedrag);
            if (!succes)
            {
                stortOp(bedrag);
            }
        }
        return succes;
    }

}
