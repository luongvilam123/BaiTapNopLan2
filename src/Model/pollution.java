package Model;

public class pollution {
    private String ts = "";
    private String aqius= "";
    private String mainus= "";
    private String aqicn= "";
    private String maincn= "";

public pollution(){

}
    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getAqius() {
        return aqius;
    }

    public void setAqius(String aqius) {
        this.aqius = aqius;
    }

    public String getMainus() {
        return mainus;
    }

    public void setMainus(String mainus) {
        this.mainus = mainus;
    }

    public String getAqicn() {
        return aqicn;
    }

    public void setAqicn(String aqicn) {
        this.aqicn = aqicn;
    }

    public String getMaincn() {
        return maincn;
    }

    public void setMaincn(String maincn) {
        this.maincn = maincn;
    }

    @Override
    public String toString() {
        return "pollution{" + "ts=" + ts + ", aqius=" + aqius + ", mainus=" + mainus + ", aqicn=" + aqicn + ", maincn=" + maincn + '}';
    }

}
