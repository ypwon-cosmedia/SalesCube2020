package estimate.common.API;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class EstimateCommonSqlProperty {
	private static final String ESTIMATE_COMMON_FILE_PATH = "C:\\Users\\cosmedia\\git\\SalesCube2020\\SalesCube2020\\src\\sql\\estimate\\estimateCommonSQLProperties.properties";
    private static final Properties estimateCommonProperties;

    private EstimateCommonSqlProperty() throws Exception {
    }

    static {
    	estimateCommonProperties = new Properties();
        try {
        	estimateCommonProperties.load(Files.newBufferedReader(Paths.get(ESTIMATE_COMMON_FILE_PATH), StandardCharsets.UTF_8));
        } catch (IOException e) {
            // ファイル読み込みに失敗
            System.out.println(String.format("ファイルの読み込みに失敗しました。ファイル名:%s", ESTIMATE_COMMON_FILE_PATH));
        }
    }

    /**
     * プロパティ値を取得する
     *
     * @param key キー
     * @return 値
     */
    public static String getEstimateCommonProperty(final String key) {
        return getEstimateCommonProperty(key, "");
    }

    /**
     * プロパティ値を取得する
     *
     * @param key キー
     * @param defaultValue デフォルト値
     * @return キーが存在しない場合: デフォルト値
     *             存在する場合    : 値
     */
    public static String getEstimateCommonProperty(final String key, final String defaultValue) {
        return estimateCommonProperties.getProperty(key, defaultValue);
    }
}
