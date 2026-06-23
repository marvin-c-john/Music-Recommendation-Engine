public enum Genre {
    HIPHOP, RNB, POP;

    @Override
    public String toString(){
       return switch (this){
            case HIPHOP ->  "Hip hop";
            case RNB ->  "Rnb";
            case POP ->  "Pop";
        };
    }
}
