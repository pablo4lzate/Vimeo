public class App {

    public static void main(String[] args) throws Exception {
    
        String  SatartingvideoUrl = "0";
        new MyFrame();
        startUserInput(SatartingvideoUrl);
    }

    public static void startUserInput(String myVideoUrl){

        System.out.println("Waiting for URL");


        while (myVideoUrl.equals("0")) {
            if( !MyFrame.getVideoURL().isEmpty()){
                myVideoUrl = MyFrame.getVideoURL();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Handle interrupted exception if needed
                e.printStackTrace();
            }
        }

        System.out.println(myVideoUrl);
        MyFrame.setVideoURL();
        Selenium.Program(myVideoUrl);

    }
    
}
