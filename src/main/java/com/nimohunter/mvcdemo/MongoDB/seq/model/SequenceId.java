package com.nimohunter.mvcdemo.MongoDB.seq.model;

/**
 * Created by nimohunter on 2017/6/14.
 * Contact me by nimohunter@gmail.com
 */
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
public class SequenceId {

    @Id
    private String id;

    private long seq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "SequenceId{" +
                "id='" + id + '\'' +
                ", seq=" + seq +
                '}';
    }
}
