
public class PatientID {
    
    // c1 c2 c3 id

    private char c1,
                 c2,
                 c3;
    private int  id;
    private Boolean isDeleted;
    private String  delRes;

    public PatientID(char c1, char c2, char c3, int id, Boolean isDeleted, String delRes) {
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.id = id;
        this.isDeleted = isDeleted;
        this.delRes = delRes;
    }

    public char getC1() {
        return c1;
    }

    public void setC1(char c1) {
        this.c1 = c1;
    }

    public char getC2() {
        return c2;
    }

    public void setC2(char c2) {
        this.c2 = c2;
    }

    public char getC3() {
        return c3;
    }

    public void setC3(char c3) {
        this.c3 = c3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getDelRes() {
        return delRes;
    }

    public void setDelRes(String delRes) {
        this.delRes = delRes;
    }

    public String getID()
    {

        String output;

        output =  "" + c1 + c2 + c3 + String.format( "%02d", getId());

        return output; 

    }

    public void increment( int increments )
    {

        for ( int i = 0; i < increments; i++ )
        {
            if ( id < 99 )
            {
                id++;
            }
            else
            {
                if ( c3 < 'Z' )
                {
                    id = 0;
                    c3++;
                }
                else
                {
                    if ( c2 < 'Z' )
                    {
                        c3 = 'A';
                        c2++;
                    }
                    else
                    {
                        if ( c1 < 'Z' )
                        {
                            c2 = 'A';
                            c1++;
                        }
                    }
                }
            }
        }
    }

}
