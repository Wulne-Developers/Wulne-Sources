package xu.zhixuan.wulne.Api.Minecraft.Test;

import xu.zhixuan.wulne.Api.Minecraft.Main.Main;

import java.io.IOException;
import java.util.Arrays;

public class Start
{
    public static void main(String[] args) throws IOException {
        Main.main(concat(new String[] {"--version", "mcp", "--accessToken", "0", "--assetsDir", "assets", "--assetIndex", "1.8", "--userProperties", "{}"}, args));
    }

    public static <T> T[] concat(T[] first, T[] second)
    {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}
