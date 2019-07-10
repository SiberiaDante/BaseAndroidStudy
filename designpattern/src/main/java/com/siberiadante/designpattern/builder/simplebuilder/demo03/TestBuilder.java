package com.siberiadante.designpattern.builder.simplebuilder.demo03;

public class TestBuilder {

    public static void main(String[] args) {
        ActorBuilder angelBuilder = new AngelBuilder();
//        ActorController actorController = new ActorController();
//        Actor actor = actorController.construct(angelBuilder);
        Actor actor = angelBuilder.construct();

        System.out.println(actor);
    }
}
