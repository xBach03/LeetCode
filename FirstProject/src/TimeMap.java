import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    public Map<String, List<DataZipper>> mp;
    public class DataZipper {
        public String value;
        public int timeStamp;
        DataZipper(String val, int timestmp) {
            value = val;
            timeStamp = timestmp;
        }
    }

    public TimeMap() {
        mp = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!mp.containsKey(key)) {
            mp.put(key, new ArrayList<>());
        }
        mp.get(key).add(new DataZipper(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<DataZipper> list = mp.get(key);
        if(list == null) return "";
        int left = 0;
        int right = list.size() - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            DataZipper midZip = list.get(mid);
            if(midZip.timeStamp == timestamp) {
                return midZip.value;
            } else if (midZip.timeStamp < timestamp) {
                if(list.get(mid + 1).timeStamp > timestamp) return midZip.value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return list.get(left).timeStamp <= timestamp ? list.get(left).value : "";
    }
}
