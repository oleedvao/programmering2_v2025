package no.hiof.oleedvao.zooregister;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;
import no.hiof.oleedvao.zooregister.controller.ZooController;
import no.hiof.oleedvao.zooregister.model.Chimp;
import no.hiof.oleedvao.zooregister.model.HoneyBadger;
import no.hiof.oleedvao.zooregister.model.Panda;
import no.hiof.oleedvao.zooregister.model.Zoo;
import no.hiof.oleedvao.zooregister.repository.ZooDataRepository;
import no.hiof.oleedvao.zooregister.repository.ZooRepository;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.staticFiles.enableWebjars();
            javalinConfig.vue.vueInstanceNameInJs = "app";
        }).start();

        ZooRepository zooRepository = new ZooDataRepository();
        ZooController zooController = new ZooController(zooRepository);

        // --- API ---
        app.post("/api/add-zoo", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                zooController.addZoo(context);
            }
        });

        app.get("/api/zoo/{zoo-name}", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                zooController.getZooByName(context);
            }
        });

        app.get("/api/all-zoos", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                zooController.getAllZoos(context);
            }
        });

        app.get("/api/mascot", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                zooController.getMascot(context);
            }
        });


        // --- Pages ---
        app.get("/add-zoo", new VueComponent("add-zoo"));

        app.get("/", new VueComponent("home-page"));

        app.get("/all-zoos", new VueComponent("zoos-overview"));

        app.get("/zoo/{zoo-name}", new VueComponent("zoo-detail"));

        app.get("/other-page", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {

                context.result("Hello from the other page!");
            }
        });

    }
}
