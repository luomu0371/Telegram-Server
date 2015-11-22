package org.telegram.tl;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.*;

public class VideoL15 extends TLVideo {

    public static final int ID = 0x388fa391;

    public long id;
    public long access_hash;
    public int user_id;
    public int date;
    public String caption;
    public int duration;
    public String mime_type;
    public int size;
    public TLPhotoSize thumb;
    public int dc_id;
    public int w;
    public int h;

    public VideoL15() {
    }

    public VideoL15(long id, long access_hash, int user_id, int date, String caption, int duration, String mime_type, int size, TLPhotoSize thumb, int dc_id, int w, int h) {
        this.id = id;
        this.access_hash = access_hash;
        this.user_id = user_id;
        this.date = date;
        this.caption = caption;
        this.duration = duration;
        this.mime_type = mime_type;
        this.size = size;
        this.thumb = thumb;
        this.dc_id = dc_id;
        this.w = w;
        this.h = h;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        id = buffer.readLong();
        access_hash = buffer.readLong();
        user_id = buffer.readInt();
        date = buffer.readInt();
        caption = buffer.readString();
        duration = buffer.readInt();
        mime_type = buffer.readString();
        size = buffer.readInt();
        thumb = (TLPhotoSize) buffer.readTLObject(APIContext.getInstance());
        dc_id = buffer.readInt();
        w = buffer.readInt();
        h = buffer.readInt();
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(32);
        serializeTo(buffer);
        return buffer;
    }

    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeLong(id);
        buff.writeLong(access_hash);
        buff.writeInt(user_id);
        buff.writeInt(date);
        buff.writeString(caption);
        buff.writeInt(duration);
        buff.writeString(mime_type);
        buff.writeInt(size);
        buff.writeTLObject(thumb);
        buff.writeInt(dc_id);
        buff.writeInt(w);
        buff.writeInt(h);
    }

    public int getConstructor() {
        return ID;
    }
}