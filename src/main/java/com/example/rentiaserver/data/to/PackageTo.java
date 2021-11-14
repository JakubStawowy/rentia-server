package com.example.rentiaserver.data.to;

import com.example.rentiaserver.data.api.BaseEntityTo;

public class PackageTo extends BaseEntityTo {

    private final String packageLength;
    private final String packageWidth;
    private final String packageHeight;
    private final String packageWeight;

    public PackageTo(Long id, String createdAt, String packageLength, String packageWidth, String packageHeight, String packageWeight) {
        super(id, createdAt);
        this.packageLength = packageLength;
        this.packageWidth = packageWidth;
        this.packageHeight = packageHeight;
        this.packageWeight = packageWeight;
    }

    public String getPackageLength() {
        return packageLength;
    }

    public String getPackageWidth() {
        return packageWidth;
    }

    public String getPackageHeight() {
        return packageHeight;
    }

    public String getPackageWeight() {
        return packageWeight;
    }
}
