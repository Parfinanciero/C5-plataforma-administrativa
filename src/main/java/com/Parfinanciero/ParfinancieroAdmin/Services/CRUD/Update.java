package com.Parfinanciero.ParfinancieroAdmin.Services.CRUD;

public interface Update <ID, Entity> {
    public Entity update(ID id, Entity entity);
}
