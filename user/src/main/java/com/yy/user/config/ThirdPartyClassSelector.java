package com.yy.user.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: ThirdPartyClassSelector
 ** @author: yangfeng
 ** @date: 2025/4/28 14:09
 ** @version: 1.0.0
 *********************************************************/
public class ThirdPartyClassSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> imports = new ArrayList<>();
        InputStream in = ThirdPartyClassSelector.class.getClassLoader().getResourceAsStream("third-party-class.properties");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = null;
        try {
            while ((line = br.readLine())!=null){
                imports.add(line);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        return imports.toArray(new String[0]);
    }
}
