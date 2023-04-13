rs_allocation inputImage;
int width;
int height;

void root(const uchar4* v_in, uchar4* v_out) {
    float4 sum = 0;
    float count = 0;

    for (int i = -4; i <= 4; i++) {
    for (int j = -4; j <= 4; j++) {
    if (i * i + j * j <= 16) {
        float4 pixel = rsUnpackColor8888(rsGetElementAt_uchar4(inputImage, rsClamp(i + rsGetElementAtYuv_uchar_Y(inputImage, width, height), 0, height - 1), rsClamp(j + rsGetElementAtYuv_uchar_Y(inputImage, width, height), 0, width - 1)));
        sum += pixel;
        count += 1;
    }
}
}

    float4 result = sum / count;
    *v_out = rsPackColorTo8888(result);
}
