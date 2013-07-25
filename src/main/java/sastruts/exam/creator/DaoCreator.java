package sastruts.exam.creator;

import org.seasar.framework.container.ComponentCreator;
import org.seasar.framework.container.ComponentCustomizer;
import org.seasar.framework.container.creator.ActionCreator;
import org.seasar.framework.container.creator.ComponentCreatorImpl;
import org.seasar.framework.container.deployer.InstanceDefFactory;
import org.seasar.framework.convention.NamingConvention;

/**
 * Daoクラス用の {@link ComponentCreator}です。
 * @author W.Ryozo
 *
 */
public class DaoCreator extends ComponentCreatorImpl {

    /**
     * 指定された{@link NamingConvention 命名規約}に従った{@link ActionCreator}を作成します。
     * 
     * @param namingConvention 命名規約
     */
    public DaoCreator(NamingConvention namingConvention) {
        super(namingConvention);
        setNameSuffix(namingConvention.getDaoSuffix());
        setInstanceDef(InstanceDefFactory.REQUEST);
    }
    
    /**
     * {@link ComponentCustomizer}を返します。
     * 
     * @return コンポーネントカスタマイザ
     */
    public ComponentCustomizer getActionCustomizer() {
        return getCustomizer();
    }

    /**
     * {@link ComponentCustomizer}を設定します。
     * 
     * @param customizer コンポーネントカスタマイザ
     */
    public void setActionCustomizer(ComponentCustomizer customizer) {
        setCustomizer(customizer);
    }

}
