package kolpackage;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibNumbers {
    public static class RestResp{
        private int num;

        public void setNum(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public int Fib1(int num){
            if(num <= 1)
                return 0;
            if(num==2)
                return 1;
            return Fib1(num-1)+Fib1(num-2);
        }

        public int Fib2(int num){
            int a, b, sum, c;
            a=c=sum=0;
            b=1;
            while(c<num){
                sum = a+b;
                a=b;
                b=sum;
                c++;
            }
            return a;
        }

        @RequestMapping(value = "/number", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<RestResp> method(@PathVariable int n){
            RestResp res = new RestResp();
            res.Fib1(n);
            res.getNum();
            res.setNum(n);
            return ResponseEntity.ok(res);
        }
    }
}
