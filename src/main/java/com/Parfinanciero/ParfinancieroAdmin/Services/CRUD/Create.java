package com.Parfinanciero.ParfinancieroAdmin.Services.CRUD;

public interface Create <EntityRequest, Entity> {
    public Entity create (EntityRequest entity);
}
