# کاربرد عملی الگوهای طراحی شئ‌گرا (Object Oriented Design Patterns)

## اعضای گروه

نگار نوبختی - 98171201

پریمهر مرصع‌فر - 98171148

## شرح آزمایش

برای پیاده‌سازی آزمایش بر اساس الگوهای state و  strategy برنامه را بر اساس class diagra زیر پیاده‌سازی می‌کنیم.

![class diagram](./assets/pattern_uml.png)

طبق دیاگرام، یک انتزاع PackageState وجود دارد که وضعیت‌های مختلف بسته آن را پیاده‌سازی می‌کنند. این انتزاع packageای را که به آن تعلق دارد در خود ذخیره می‌کند و یک متد sendPackage دارد که بسته آن را فراخوانی می‌کند. در صورتی که وضعیت بسته از نوع InTransitState باشد، وضعیت آن به DeliveredState تغییر می‌کند و در غیر اینصورت در وضعیت خود باقی می‌ماند. بدین صورت الگوی state برآورده می‌شود.

برای برآورده کردن الگوی Strategy، یک انتزاع shippingMethod را پیاده‌سازی می‌کنیم، که روش‌های مختلف ارسال آن را پیاده‌سازی می‌کنند. با هر بار تغییر روش ارسال بسته شیوه ارسال را در خود ذخیره می‌کند و با اجرای تابع ship()، تابع مربوطه در روش ارسال بسته نیز فراخوانی شده و پیغام و قیمت مربوط به خود را چاپ می‌کند. بدین صورت الگوی strategy نیز برآورده می‌شود.

در ابتدا تست‌های برنامه نوشته شده و در ادامه برنامه اصلی پیاده‌سازی شده‌است.

![test pass](./assets/test_pass.png)

## پرسش‌ها
1. در کتاب GoF سه دسته الگوی طراحی معرفی شده است. آن‌ها را نام ببرید و در مورد هر دسته در حد دو خط توضیح دهید.

- **creational**: این دسته از الگو‌ها مربوط به شیوه ایجاد موجودیت‌ها هستند، به شکلی که متناسب با مساله باشند. زیرا ایجاد موجودیت‌ها در ابتدایی‌ترین شکل خود می‌تواند در بعضی مسائل پیچیدگی‌هایی را ایجاد کند.
- **structural**: این نوع الگو‌ها رابطه میان موجودیت‌ها را مدیریت می‌کنند و تعیین می‌کنند که موجودیت‌های مختلف به چه صورتی باید در کنار هم قرار بگیرند تا ساختارهای بزرگ‌تر را ایجاد کنند.
- **behavioral**: این دسته از الگوها بر نحوه ارتباط و تقسیم وظایف میان موجودیت‌ها نظارت دارند. با استفاده از این الگوها می‌توان انعطاف را در ارتباط میان موجودیت‌ها افزایش داد.

2. الگوهای استفاده شده در این آزمایش جزو کدام دسته هستند؟

هر دو الگو از نوع behavioral هستند.

3. با توجه به این که در هر اجرا محصرا یک بسته داریم و هیچ بسته‌ی دیگری بجز آن نداریم، کدام الگوی طراحی را برای ایحاد آن مناسب می‌دانید؟ ضمن بیان علت انتخاب خود، نحوه تحقق الگو را به طور کامل توضیح دهید.

الگوی Singleton - این الگو بدین منظور ساخته شده که از یک موجودیت تنها بتوان یک عدد داشت. برای آنکه موجودیت بسته از این الگو پیروی کند، یک attribute استاتیک از جنس خودش را نگاه می دارد، تابع constructor آن private است و تابعی استاتیک به نام getInstance دارد. در صورتی که اینستنسی از بسته در attribute استاتیک وجود داشته باشد، همان را باز می گرداند و در غیراینصورت یک اینستنس ساخته و آن را باز می‌گرداند.

نمونه کد آن به صورت زیر است:

```
class Package {
 static private Package instance;
 private int weight;

 private Package(int weight) {
  this.weight = weight;
 }

 static Package getInstance(int weight) {
  if (instance == null) {
   instance = new Package(weight);
  }
  return instance;
 }
}
```

4. تحقق و یا عدم تحقق هر کدام از اصول SOLID را در خصوص الگوی طراحی Singleton بیان کنید (هرکدام حداکثر در سه خط).
1. Single Responsibility Principle
   - تحقق: الگوی Singleton تمرکز بر ایجاد یک نمونه از یک کلاس است و تنها یک وظیفه دارد: ایجاد یک نمونه یکتا از یک کلاس و ارائه آن.
     
   -عدم تحقق: اگر کلاس Singleton بیش از یک وظیفه داشته باشد (مثلاً به علاوه از ایجاد نمونه، مسئولیت‌های دیگر را هم بپذیرد)، می‌تواند به نقض اصل S منجر شود.

2. Open/Closed Principle
   - تحقق: کلاس Singleton به راحتی قابل گسترش است بدون اینکه بخش‌های موجود تغییر کنند. اگر بخواهیم تغییراتی در دیگر قسمت‌های کد اعمال کنیم، کافی است روی کلاس Singleton تغییری ایجاد نکنیم.
     
   - عدم تحقق: اگر کد مرتبط با Singleton بخش‌های دیگر کد را به شدت تحت تأثیر قرار دهد (به عنوان مثال، با متد‌های استاتیک کلاس دیگرها تداخل کند)، ممکن است این اصل رعایت نشود.

3.Liskov Substitution Principle
   - تحقق: الگوی Singleton نیازی به جایگزینی ندارد، زیرا همیشه یک نمونه از کلاس در دسترس است و تغییرات در نحوه ایجاد آن نمونه تأثیری بر رابطه با دیگر کلاس‌ها ندارد.
     
   - عدم تحقق:  اگر مکانیزم ایجاد نمونه Singleton به نحوی پیچیده شود که باعث تغییر در رابطه با دیگر کلاس‌ها شود (به عنوان مثال، نیاز به تغییر در سایر کدها برای پشتیبانی از تغییر در الگوی Singleton)، این اصل ممکن است نقض شود.

4. Interface Segregation Principle
   - تحقق: الگوی Singleton به عنوان یک الگوی طراحی، معمولاً با رابطهای کاربری کمی سر و کار دارد و نیازی به اجتناب از ایجاد چندین رابط ندارد.
     
   - عدم تحقق: اگر Singleton تعداد زیادی رابطها را پیاده‌سازی کند یا به چندین رابطه وابسته باشد، ممکن است این اصل نقض شود. در الگوهای طراحی که به تعداد زیادی رابطها نیاز دارند، ممکن است اصل جداسازی رابط حائز اهمیت تری باشد.

5. Dependency Inversion Principle
   -تحقق: الگوی Singleton توسط کلاس‌ها به عنوان یک منبع تکرارپذیر از تکنولوژی یا خدمات به‌عنوان وابستگی استفاده می‌شود، که باعث تعداد دسترسی‌ها و وابستگی‌ها کاهش می‌یابد.
   
   - عدم تحقق: اگر Singleton به طور مستقیم به جزئیات پیاده‌سازی کلاس‌های دیگر وابسته باشد، اصل وابستگی برعکس نقض می‌شود. برای رعایت این اصل، باید Singleton به معنای کلی‌تر وابستگی به ابسته‌های خود کاهش یابد و به رابطها یا تعداد کمتری از کلاس‌ها وابسته شود.
