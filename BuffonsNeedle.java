import java.util.Scanner;


public class BuffonsNeedle {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter number of iterations: ");
        int iterations = Integer.parseInt(console.next());
        console.close();

        int hits = 0;
        for (int i = 0; i < iterations; i++) {
            Needle n = randomNeedle(1);
            hits += Math.floor(n.pos[0]) != Math.floor(n.end[0]) ? 1 : 0;
        }

        double chance = (double)hits / iterations;
        double approx_pi = 2.0 / chance;
        System.out.println(iterations + " / " + hits + " = " + approx_pi);
    }

    private static Needle randomNeedle (double l) {
        double angle = Math.random() * Math.PI; 
        double[] pos = new double[]{Math.random(), Math.random()};
        return new Needle(l, angle, pos);
    }

    
    private static class Needle {
        double length, angle;
        double[] pos, end;
        
        private Needle (double length, double angle, double[] pos) {
            this.length = length;
            this.angle = angle;
            this.pos = pos;
            this.end = new double[]{
                this.length * Math.cos(this.angle) + this.pos[0],
                this.length * Math.sin(this.angle) + this.pos[1]
            };
        }
    }
}
