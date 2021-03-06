public class Worker extends Thread{

    private int id;
    private Data data;

    public Worker(int id, Data d){
        this.id = id;
        data = d;
        this.start();
    }

    @Override
    public void run(){
        super.run();
        synchronized (data) {

                    for (int i = 0; i < 5; i++) {
                        try {
                            while (id != data.getState()) {
                                data.wait();
                            }
                            if (id == 2) {
                                data.Toe();
                            }
                            else if (id == 3){
                                data.Tic();
                            }
                            else {
                                data.Tak();
                            }
                            data.notify();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

        }
    }


}