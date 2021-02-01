package top.arsiac.psychology.utils.common;

import org.springframework.beans.BeanUtils;
import top.arsiac.psychology.utils.exception.PsychologyErrorCode;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>对象复制</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public class BeanCopy {

    /**
     * <p>将 source 拷贝成 targetClass 类型的对象</p>
     * <p>目标类必须有无参构造函数</p>
     *
     *
     * @param source 源对象
     * @param targetClass 目标类型
     * */
   public static <T> T copy(Object source, Class<T> targetClass) {
       // 源对象为 null, 则目标对象也为 null
       if (source == null) {
           return null;
       }

       try {
           // 调用无参构造函数创建
           T target = targetClass.getDeclaredConstructor().newInstance();
           // 复制属性
           BeanUtils.copyProperties(source, target);
           return target;
       } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
           throw PsychologyErrorCode.CREATE_TARGET_OBJECT_FAILED.createException(e);
       }
   }

   /**
    * <p>将源对象中的属性复制到目标对象</p>
    * <p>源对象目标对象皆为 null, 则无需进行复制</p>
    * <p>如果源对象为 null, 则不能进行复制, 无法将目标对象变为 null, 抛出异常</p>
    * <p>如果目标对象为 null, 复制无法进行，抛出异常</p>
    *
    * @param source 源对象
    * @param target 目标对象
    * */
   public static void copy(Object source, Object target) {
       if (source == null && target == null) {
           return;
       }
       if (source == null) {
           throw PsychologyErrorCode.SOURCE_OBJECT_IS_NULL.createException();
       }
       if (target == null) {
           throw PsychologyErrorCode.TARGET_OBJECT_IS_NULL.createException();
       }

       // 复制属性
       BeanUtils.copyProperties(source, target);
   }

    /**
     * <p>将 E 类型的列表拷贝成 T 类型的列表</p>
     *
     * @param sourceList 源列表
     * @param targetClass 目标类型
     * @param callback 复制回调函数
     * @return 目标列表
     */
   public static <E, T> List<T> copyList(List<E> sourceList, Class<T> targetClass, CopyCallback callback) {
       if (sourceList == null || sourceList.isEmpty()) {
           return new ArrayList<>(0);
       }

       List<T> targetList = new ArrayList<>(sourceList.size());
       for (E source : sourceList) {
           T target = copy(source, targetClass);

           // 源为 null，则 目标对象也为 null， 无需复制
           if (source != null && callback != null) {
               // 额外复制
               callback.copy(source, target);
           }

           targetList.add(target);
       }

       return targetList;
    }

    /**
     * <p>将 E 类型的列表拷贝成 T 类型的列表</p>
     *
     * @param sourceList 源列表
     * @param targetClass 目标类型
     * @return 目标列表
     */
    public static <E, T> List<T> copyList(List<E> sourceList, Class<T> targetClass) {
       return copyList(sourceList, targetClass, null);
    }

    /**
     * <p>复制列表回调函数</p>
     *
     * @author arsiac
     * @version 1.0
     * @since  2021/1/31
     */
    interface CopyCallback {

        /**
         * <p>复制回调</p>
         *
         * @param source 源对象
         * @param target 目标对象
         * */
       void copy(Object source, Object target);
    }
}
