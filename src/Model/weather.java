package Model;

public class weather {
    private String ts = "";
    private String tp= "";
    private String pr= "";
    private String hu= "";
    private String ws= "";
    private String wd= "";
    private String ic= "";

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr = pr;
    }

    public String getHu() {
        return hu;
    }

    public void setHu(String hu) {
        this.hu = hu;
    }

    public String getWs() {
        return ws;
    }

    public void setWs(String ws) {
        this.ws = ws;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    @Override
    public String toString() {
        return "weather{" + "ts=" + ts + ", tp=" + tp + ", pr=" + pr + ", hu=" + hu + ", ws=" + ws + ", wd=" + wd + ", ic=" + ic + '}';
    }

}
