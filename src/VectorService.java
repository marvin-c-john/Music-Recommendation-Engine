public class VectorService {



    public double[] toVector(Song s){
        return  new double[]{s.getEnergy(), s.getDanceability(), s.getValence(), s.getAcousticness(), s.getInstrumentalness(), s.getTempo()};
    }



    public double cosineSimilarity(double[] a, double[] b) {
        double dotProduct = 0;
        double magnitudeA = 0;
        double magnitudeB = 0;

        //Skalarprodukt
        for (int i = 0; i < a.length; i++) {

            double interim = 0;
            double value1 = a[i];
            double value2 = b[i];

            interim = value1 * value2;
            dotProduct += interim;

        }


        // Betrag a
        for (int i = 0; i < a.length; i++) {
            double value1 = a[i];
            double interim =  value1 * value1;;
            magnitudeA += interim;
        }

        // Betrag b
        for (int i = 0; i < b.length; i++) {
            double value1 = b[i];
            double interim = value1 *= value1;
            magnitudeB += interim;
        }



        dotProduct  = dotProduct/ (Math.sqrt(magnitudeA) * Math.sqrt(magnitudeB));


        return (double) Math.round(dotProduct * 100) /100 ;

    }


}

