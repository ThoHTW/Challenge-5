package sensorData;

import streamMachine.StreamMachine;
import transmission.DataConnection;

import java.io.DataInputStream;
import java.io.IOException;

public class SensorDataReceiver {
    private final DataConnection connection;
    private final StreamMachine storage;

    public SensorDataReceiver(DataConnection connection, StreamMachine storage) {
        this.connection = connection;
        this.storage = storage;
    }

    public StreamMachine getStorage() {
        return storage;
    }


    public DataInputStream getInputStream() throws IOException {
        return this.connection.getDataInputStream();
    }
}