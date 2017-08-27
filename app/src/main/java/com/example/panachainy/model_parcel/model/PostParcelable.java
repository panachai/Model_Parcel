package com.example.panachainy.model_parcel.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class PostParcelable implements Parcelable {
    static final long serialVersionUID = 42L;

    private String title;
    private String content;
    private String id;
    private String date;
    private String author;
    private String url;
    private int readCount;
    private boolean isDraft;
    private List<String> tagist;

    private List<Comment> commentList;

    public PostParcelable() {
    }

    protected PostParcelable(Parcel in) {
        title = in.readString();
        content = in.readString();
        id = in.readString();
        date = in.readString();
        author = in.readString();
        url = in.readString();
        readCount = in.readInt();
        isDraft = in.readByte() != 0;
        tagist = in.createStringArrayList();
    }

    public static final Creator<PostParcelable> CREATOR = new Creator<PostParcelable>() {
        @Override
        public PostParcelable createFromParcel(Parcel in) {
            return new PostParcelable(in);
        }

        @Override
        public PostParcelable[] newArray(int size) {
            return new PostParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(content);
        parcel.writeString(id);
        parcel.writeString(date);
        parcel.writeString(author);
        parcel.writeString(url);
        parcel.writeInt(readCount);
        parcel.writeByte((byte) (isDraft ? 1 : 0)); //boolean parcel
        parcel.writeStringList(tagist);

    }

    public static class Comment implements Parcelable {
        private String comment;
        private String user;
        private String date;

        public Comment() {

        }

        protected Comment(Parcel in){
            comment = in.readString();
            user = in.readString();
            date = in.readString();
        }

        public static final Creator<Comment> CREATOR = new Creator<Comment>() {
            @Override
            public Comment createFromParcel(Parcel in) {
                return new Comment(in);
            }

            @Override
            public Comment[] newArray(int size) {
                return new Comment[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(comment);
            parcel.writeString(user);
            parcel.writeString(date);
        }
    }
}