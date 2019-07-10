package com.siberiadante.designpattern.builder.simplebuilder.demo02;

public class TestBuilder {

    public static void main(String[] args) {
        ActorBuilder angelBuilder = new AngelBuilder();
        ActorController actorController = new ActorController();
        Actor actor = actorController.construct(angelBuilder);

        System.out.println(actor);
    }
}
