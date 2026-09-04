public class BMICalculator {
    static String getBmiStatus(double bmi){
        if(bmi<18.5) return "Underweight";
        if(bmi<25) return "Normal";
        if(bmi<30) return "Overweight";
        return "Obese";
    }
    public static void main(String[] args){
        double[] heights = {1.75,1.60,1.82,1.68,1.70,1.55,1.78,1.65,1.80,1.62};
        double[] weights = {70,90,85,60,75,50,95,68,88,58};
        System.out.println("Person | Height | Weight | BMI | Status");
        for(int i=0;i<10;i++){
            double bmi = weights[i]/(heights[i]*heights[i]);
            System.out.printf("%d | %.2f m | %.0f kg | %.2f | %s\n",i+1,heights[i],weights[i],bmi,getBmiStatus(bmi));
        }
    }
}