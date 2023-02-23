package compare_version_numbers_165;

/*
    Given two version numbers, version1 and version2, compare them.
 */
public class Main {
    public static int compareVersion(String version1, String version2) {
        if(version1.isEmpty()){
            return version2.matches("(\\.|0)*") ? 0 : -1;
        }

        if(version2.isEmpty()){
            return version1.matches("0*") ? 0 : 1;
        }

        int left = version1.indexOf('.'), right = version2.indexOf('.');

        int val1 = Integer.parseInt(version1.substring(0, left < 0 ? version1.length() : left));
        int val2 = Integer.parseInt(version2.substring(0, right < 0 ? version2.length() : right));

        if(val1 < val2){
            return -1;
        }else if(val1 > val2){
            return 1;
        }else{
            return compareVersion(left<0?"":version1.substring(left+1), right<0?"":version2.substring(right+1));
        }
    }

    public static void main(String[] args){
        System.out.println("0.0.1".matches("(0|\\.)*"));
        //System.out.println(compareVersion("0.01", "0.001"));
    }
}
