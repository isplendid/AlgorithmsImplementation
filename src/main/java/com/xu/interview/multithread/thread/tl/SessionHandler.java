package com.xu.interview.multithread.thread.tl;

/**
 * Created by sop on 2020/09/2020/9/2 10:55
 *
 * @Description:
 */
public class SessionHandler {
    public static ThreadLocal<Session> session = ThreadLocal.withInitial(() -> new Session());


    public static class Session {
        private String id;
        private String user;
        private String status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public String getUser() {
        return session.get().getUser();
    }

    public String getStatus() {
        return session.get().getStatus();
    }

    public void setStatus(String status) {
        session.get().setStatus(status);
    }

    public static void main(String[] args) {
        System.out.println("start!");
        new Thread(() -> {
            SessionHandler handler = new SessionHandler();
            System.out.println(handler.getStatus());
            System.out.println(handler.getUser());;


            handler.setStatus("close");;
            System.out.println(handler.getStatus());
            Session newS = new Session();
            newS.setUser("xsc");
            session.set(newS);
        }).start();
    }
}
