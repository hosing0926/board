import Header from './Header'
import Footer from "@/pages/components/Footer";

export default function Layout({children}) {
    return (
        <div>
            <Header/>
                <main>{children}</main>
            <Footer/>
        </div>
    )
}